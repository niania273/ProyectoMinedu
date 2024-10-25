package com.minedu.project.maintenance_management.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.minedu.project.maintenance_management.model.Equipo;
import com.minedu.project.maintenance_management.model.Solicitante;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.repository.EquipoRepository;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;
import com.minedu.project.maintenance_management.repository.SolicitanteRepository;
import com.minedu.project.maintenance_management.repository.SolicitudEquipoRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;
import com.minedu.project.maintenance_management.service.SolicitanteService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@ExtendWith(MockitoExtension.class)
public class SolicitudServiceTest {
	
	@Mock
	private SolicitudRepository solicitudRepository;
	
	@Mock
	private SolicitanteRepository solicitanteRepository;
	
	@Mock
	private SolicitudEquipoRepository solicitudEquipoRepository;
	
	@Mock
	private EquipoRepository equipoRepository;
	
	@Mock
	private RequerimientoRepository requerimientoRepository;
	
	@Mock
    private SolicitanteService solicitanteService;
	
	@InjectMocks
	private SolicitudService solicitudService;
	
	
	private Solicitud solicitud;
	private SolicitudDTO solicitudDTO;
	private Solicitante solicitante;
	
	@Test
	public void testFindAllSolicitudes() {
		
		solicitud = new Solicitud();
		solicitud.setCodSol("ST101");
		solicitud.setDesSol("Solicitud de prueba");
		solicitud.setCatSol("Hardware");
		solicitud.setNivPri("Alta");
		solicitud.setEstSol("Pendiente");
		
		Mockito.when(solicitudRepository.findAll()).thenReturn(Arrays.asList(solicitud));
		assertNotNull(solicitudService.findAllSolicitudes());
		
		List<Solicitud> solicitudes = solicitudService.findAllSolicitudes();
		assertEquals(1, solicitudes.size());
		assertEquals("Solicitud de prueba", solicitudes.get(0).getDesSol());
	}
	
	@Test
	public void testFindSolicitudById() {
		solicitud = new Solicitud();
		solicitud.setCodSol("ST103");
		Mockito.when(solicitudRepository.findById(solicitud.getCodSol())).thenReturn(Optional.of(solicitud));
		
		Solicitud solicitudEncontrada = solicitudService.findSolicitudById("ST103");
		assertEquals("ST103", solicitudEncontrada.getCodSol());
	}
	
	@Test
	public void testFindSolicitudDTOById() {
	    Solicitante solicitante = new Solicitante();
	    solicitante.setCodSoli("SL106");

	    Solicitud solicitud = new Solicitud();
	    solicitud.setCodSol("ST106");
	    solicitud.setSolicitante(solicitante);

	    Mockito.when(solicitudRepository.findById("ST106")).thenReturn(Optional.of(solicitud));

	    SolicitudDTO solicitudDTO = new SolicitudDTO();
	    solicitudDTO.setCodSol("ST106");
	    solicitudDTO.setCodSoli(solicitante.getCodSoli());

	    assertNotNull(solicitudDTO);
	    assertEquals("ST106", solicitudDTO.getCodSol());
	    assertEquals("SL106", solicitudDTO.getCodSoli());

	    SolicitudDTO resultadoSolicitudDTO = solicitudService.findSolicitudDTOById("ST106");

	    assertNotNull(resultadoSolicitudDTO);
	    assertEquals("ST106", resultadoSolicitudDTO.getCodSol());
	    assertEquals("SL106", resultadoSolicitudDTO.getCodSoli());
	}

	
	@Test
	public void updateSolicitud() {

	    solicitudDTO = new SolicitudDTO();
	    solicitudDTO.setCodSol("ST102");
	    solicitudDTO.setCodSoli("SL101");
	    solicitudDTO.setCatSol("Software");
	    solicitudDTO.setNivPri("Alta");
	    solicitudDTO.setEstSol("Aprobada");

	    solicitante = new Solicitante();
	    solicitante.setCodSoli(solicitudDTO.getCodSoli());

	    solicitud = new Solicitud();
	    solicitud.setCodSol(solicitudDTO.getCodSol());
	    solicitud.setSolicitante(solicitante);

	    Equipo equipo = new Equipo();
	    equipo.setCodEqu("EQ101");
	    equipo.setNomEqu("Nuevo equipo");

	    SolicitudEquipo solEqu = new SolicitudEquipo();
	    solEqu.setEquipo(equipo);
	    solEqu.setCanEqu((byte) 2);

	    List<SolicitudEquipo> equipos = new ArrayList<>();
	    equipos.add(solEqu);
	    solicitudDTO.setEquipos(equipos);

	    Mockito.when(solicitanteService.findById(solicitudDTO.getCodSoli())).thenReturn(solicitante);
	    Mockito.when(solicitudRepository.findById(solicitudDTO.getCodSol())).thenReturn(Optional.of(solicitud));
	    Mockito.when(equipoRepository.findById(equipo.getCodEqu())).thenReturn(Optional.of(equipo));
	    Mockito.when(solicitudEquipoRepository.save(any(SolicitudEquipo.class))).thenReturn(solEqu);

	    solicitudService.updateSolicitud(solicitudDTO);

	    Mockito.verify(solicitanteRepository, Mockito.times(1)).save(solicitante);
	    Mockito.verify(solicitudRepository, Mockito.times(1)).save(solicitud);
	    Mockito.verify(solicitudEquipoRepository, Mockito.times(1)).save(solEqu);

	    assertEquals("Software", solicitud.getCatSol());
	    assertEquals("Alta", solicitud.getNivPri());
	    assertEquals("Aprobada", solicitud.getEstSol());
	}
	
	@Test
	public void testDeleteSolicitud() {
		
		String codSol = "ST103";

	    List<SolicitudEquipo> equiposAsociados = new ArrayList<>();
	    SolicitudEquipo solicitudEquipo = new SolicitudEquipo();
	    Equipo equipo = new Equipo();

	    equipo.setCodEqu("EQ101");
	    solicitudEquipo.setEquipo(equipo);
	    equiposAsociados.add(solicitudEquipo);

	    Mockito.when(solicitudEquipoRepository.findBySolicitud_CodSol(codSol)).thenReturn(equiposAsociados);
	    Mockito.doNothing().when(equipoRepository).delete(equipo);
	    Mockito.doNothing().when(solicitudEquipoRepository).deleteBySolicitud_CodSol(codSol);
	    Mockito.doNothing().when(requerimientoRepository).deleteBySolicitud_CodSol(codSol);
	    Mockito.doNothing().when(solicitudRepository).deleteById(codSol);

	    solicitudService.deleteSolicitud(codSol);

	    Mockito.verify(equipoRepository, Mockito.times(1)).delete(equipo);
	    Mockito.verify(solicitudEquipoRepository, Mockito.times(1)).deleteBySolicitud_CodSol(codSol);
	    Mockito.verify(requerimientoRepository, Mockito.times(1)).deleteBySolicitud_CodSol(codSol);
	    Mockito.verify(solicitudRepository, Mockito.times(1)).deleteById(codSol);
	}
}
