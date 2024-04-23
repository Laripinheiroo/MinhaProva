import java.util.ArrayList;
import java.util.Scanner;


class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
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

public class CasaMaisVigiada {

    public static void main(String[] args) {
        ArrayList<Jogador1> participantes = inicializarParticipantes();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Casa Mais Vigiada do Brasil!");
        System.out.println("Vote em quem você deseja eliminar da casa (digite 'sair' para encerrar):");

        while (true) {
            String voto = scanner.nextLine();
            if (voto.equalsIgnoreCase("sair")) {
                break;
            } else {
                registrarVoto(participantes, voto);
            }
        }

        scanner.close();

        Jogador1 eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {
            System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n "
                    + "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir\n "
                    + "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te "
                    + "eliminar com alegria.\n Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        } else {
            System.out.println("Não houve eliminação nesta votação.");
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
                System.out.println("Voto registrado para " + jogador.getNome());
                return;
            }
        }
        System.out.println("O participante '" + voto + "' não foi encontrado.");
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