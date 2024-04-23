
import javax.swing.*;
        import java.util.ArrayList;

class Jogador1 {
    private String nome;
    private int votos;

    public Jogador1(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }
}

public class CasaMaisVigiadaGUI {

    public static void main(String[] args) {
        ArrayList<Jogador1> participantes = inicializarParticipantes();

        JOptionPane.showMessageDialog(null, "Bem-vindo à Casa Mais Vigiada do Brasil!");

        String voto;
        do {
            voto = JOptionPane.showInputDialog("Vote em quem você deseja eliminar da casa (digite 'sair' para encerrar):");
            if (!voto.equalsIgnoreCase("sair")) {
                registrarVoto(participantes, voto);
            }
        } while (!voto.equalsIgnoreCase("sair"));

        Jogador1 eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {
            JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n "
                    + "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir\n "
                    + "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te "
                    + "eliminar com alegria.\n Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Não houve eliminação nesta votação.");
        }
    }

    private static ArrayList<Jogador1> inicializarParticipantes() {
        ArrayList<Jogador1> participantes = new ArrayList<>();
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
                "Yasmin Brunet"};
        for (String nome : nomes) {
            participantes.add(new Jogador1(nome));
        }
        return participantes;
    }

    private static void registrarVoto(ArrayList<Jogador1> participantes, String voto) {
        for (Jogador1 jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto registrado para " + jogador.getNome());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "O participante '" + voto + "' não foi encontrado.");
    }

    private static Jogador1 encontrarEliminado(ArrayList<Jogador1> participantes) {
        Jogador1 eliminado = null;
        int maxVotos = 0;
        for (Jogador1 jogador : participantes) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                eliminado = jogador;
            }
        }
        return eliminado;
    }
}

