package com.a02.training;

public class ThreadSemaforo implements Runnable{
    private CorSemaforo cor;
    private boolean parar;
    private boolean corMudou;

    public ThreadSemaforo() {
        this.setCor(CorSemaforo.VERMELHO);
        this.setParar(false);//opcional já que o padrão é falso
        this.setCorMudou(false);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(!parar){
            try {
                /*switch (this.cor){
                    case VERMELHO:
                        Thread.sleep(2000);
                        break;
                    case AMARELO:
                        Thread.sleep(300);
                        break;
                    case VERDE:
                        Thread.sleep(1000);
                        break;
                    default:
                        break;
                }*/
                Thread.sleep(this.cor.getTempoEspera());
                this.mudarCor();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    private synchronized void mudarCor(){
        switch (this.cor){
            case VERMELHO:
                this.cor = CorSemaforo.VERDE;
                break;
            case AMARELO:
                this.cor = CorSemaforo.VERMELHO;
                break;
            case VERDE:
                this.cor = CorSemaforo.AMARELO;
                break;
            default:
                break;
        }
        this.setCorMudou(true);
        notify();
    }

    public synchronized void esperaCorMudar(){
        while(!this.corMudou){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setCorMudou(false);
    }

    public CorSemaforo getCor() {
        return this.cor;
    }

    public void setCor(CorSemaforo cor) {
        this.cor = cor;
    }

    public synchronized void setParar(boolean parar) {
        this.parar = parar;
    }

    public void setCorMudou(boolean corMudou) {
        this.corMudou = corMudou;
    }

}

