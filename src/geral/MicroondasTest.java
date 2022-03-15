package geral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MicroondasTest {
    
    Microondas tempo;
    Microondas soSegundos;

    @BeforeEach
    void init(){
        tempo = new Microondas(1, 10);
        soSegundos = new Microondas(50);
    }

    @Test
    void testarTempo(){
        assertEquals("01:10", tempo.mostraTempo());
    }

    @Test
    void testarTempoSegundos(){
        assertEquals("00:50", soSegundos.mostraTempo());
    }

    @Test
    void adicionarTempo(){
        tempo.adicionarSegundos(10);
        assertEquals("01:20", tempo.mostraTempo());
    }

    @Test
    void adicionarTempoAMais(){
        soSegundos.adicionarSegundos(11);
        assertEquals("01:01", soSegundos.mostraTempo());
    }

    @Test
    void adicionarTempoUltrapassandoLimite(){
        soSegundos.adicionarSegundos(6000);
        assertEquals("60:00", soSegundos.mostraTempo());
    }

    @Test
    void estadoDoMicroondas(){
        assertEquals(true, soSegundos.estado);
    }

    @Test
    void desligarMicroondas(){
        assertEquals(false, soSegundos.DesligarMicroondas());
    }

    @Test
    void situacaoPortaSemDesligarMicroondas(){
        soSegundos.abrirPorta();
        assertEquals(false, soSegundos.situacaoPorta);
    }

    @Test
    void situacaoPortaComMicroondasDesligado(){
        soSegundos.DesligarMicroondas();
        soSegundos.abrirPorta();
        assertEquals(true, soSegundos.situacaoPorta);
    }


}