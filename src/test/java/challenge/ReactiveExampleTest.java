package challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import reactor.core.publisher.Mono;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    @Test
    void sumaDePuntajes(){

        var valor = reactiveExample.sumaDePuntajes();

        Mono<Integer> esperado = Mono.just(260);
        //assert
        Assertions.assertEquals(260, valor.block());

    }

    @Test
    void mayorPuntajeDeEstudiante(){

        var valor = reactiveExample.mayorPuntajeDeEstudiante(1);
        //assert

        Assertions.assertEquals("pedro", valor.blockFirst().getNombre());

    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){
        //arrange
        //act
        var valor = reactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(75);
        //assert
        System.out.println(valor.block());
    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){
        var valor = reactiveExample.elEstudianteTieneAsistenciasCorrectas(
                new Estudiante("raul", 30, List.of(5,2,1,4,5))
        );
        //assert
        Assertions.assertTrue(valor.block());
    }

    @Test
    void promedioDePuntajesPorEstudiantes(){
        //arrange
        //act
        var valor = reactiveExample.promedioDePuntajesPorEstudiantes();
        //assert
        Assertions.assertEquals(52, valor.block());
    }

    @Test
    void estudiantesAprovados(){
        //arrange
        //act
        var valor = reactiveExample.estudiantesAprovados();
        //assert
        System.out.println(valor);
    }
}