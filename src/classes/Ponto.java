package classes;

/**
 * Classe responsável pela configuração do Ponto
 * 
 */

public class Ponto {
	
    private int x;
    private int y;

    //construtor de Ponto
    public Ponto(int x, int Y) {
        this.x = x;
        this.y = Y;
    }
    
    public int desenhaX() {
        return x * ConstantesGlobais.TAMANHO_PONTO + ConstantesGlobais.INI_X;
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int desenhaY() {
        return y * ConstantesGlobais.TAMANHO_PONTO + ConstantesGlobais.INI_Y;
    }

    public int getY() {
        return y;
    }

    public void setY(int Y) {
        this.y = Y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto other = (Ponto) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }   
    
}
