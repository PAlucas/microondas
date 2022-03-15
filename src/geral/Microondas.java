package geral;

public class Microondas {
    
    //atributos
    public boolean situacaoPorta;
    public boolean estado;
    public int segundos;
    public int minutos;

    private void init(int minutos, int segundos){
        this.minutos = minutos;
        this.segundos = segundos;
        this.estado = true;
    }

    /**
     * Construtor colocando o parâmetro minutos e colocando o parâmetro segundos.
     * @param minutos
     * @param segundos
     */
    public Microondas(int minutos, int segundos){
        this.init(minutos, segundos);
    }

    /**
     * Construtor colocando apenas o parâmetro segundos
     * @param segundos
     */
    public Microondas(int segundos){
        this.init(0 ,segundos);
    }

    /**
     * Função que retorna o tempo de minuto e tempo.
     * @return
     */
    public String mostraTempo(){
        String minutosFinal = String.format("%02d", this.minutos);
        String segundosFinal = String.format("%02d", this.segundos);
        return minutosFinal + ':' + segundosFinal;
    }

    /**
     * Função que adiciona segundos 
     * @param segundosAdicionados
     * @return void logo ela muda valores de segundo e minuto e não retorna nada.
     */
    public void adicionarSegundos(int segundosAdicionados){
        for(int i = 0; i < segundosAdicionados; i++){
            if(dataValida() != 0){
                if(dataValida() == 1){
                    this.segundos = 0;
                    this.minutos ++;
                }else{
                    break;
                }
            }else{
                this.segundos++;   
            }
        }
    }
    /**
     * Função que desliga o microondas
     * @return estado bool que fornece se o microondas está ligado ou desligado.
     */
    public Boolean DesligarMicroondas(){
        this.estado = false;
        return this.estado;
    }

    /**
     * Função que abre porta
     * @return situacaoPorta bool que fornece se a porta está fechada ou aberta.
     */
    public Boolean abrirPorta(){
        if(estado == false){
            this.situacaoPorta = true;
        }
        return this.situacaoPorta;
    }

    /**
     * Estipulado o máximo para ser 60 minutos, retorna de 1 segundo até 60 minutos.
     * @return extrapolou int que fornece se extrapolou minuto ou segundo.
     */
    private int dataValida(){
        int extrapolou = 0;
        if(this.segundos >= 59){
            extrapolou = 1;
        }else if(this.minutos == 60){
            extrapolou = 2;
        }
        return extrapolou;
    }
}
