import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        String dados = "";

        while (true) {
            System.out.println("Digite nome-sexo: ou digite 'mostrar lista' para exibir as mulheres ou 'sair' para encerrar");
            dados = scanner.nextLine();
            if (dados.equalsIgnoreCase("sair")) {
                break;
            }
            if (dados.equalsIgnoreCase("mostrar lista")) {
                mostrarListaMulheres(pessoas);
                continue;
            }

            String[] dadosSeparados = dados.split("-");
            if (dadosSeparados.length < 2) {
                System.out.println("Entrada inválida. Por favor, digite no formato 'nome-sexo'.");
                continue;
            }

            Pessoa p = new Pessoa();
            p.setNome(dadosSeparados[0].trim());
            p.setSexo(dadosSeparados[1].trim().toLowerCase());

            pessoas.add(p);
        }

        scanner.close();
    }

    private static void mostrarListaMulheres(List<Pessoa> pessoas) {
        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> isMulher(pessoa.getSexo()))
                .collect(Collectors.toList());

        if (mulheres.isEmpty()) {
            System.out.println("Nenhuma mulher cadastrada.");
        } else {
            mulheres.forEach(System.out::println);
        }
    }

    private static boolean isMulher(String sexo) {
        return sexo.equalsIgnoreCase("f") ||
                sexo.equalsIgnoreCase("feminino") ||
                sexo.equalsIgnoreCase("mulher");
    }

    private static boolean isHomem(String sexo) {
        return sexo.equalsIgnoreCase("m") ||
                sexo.equalsIgnoreCase("masculino") ||
                sexo.equalsIgnoreCase("homem");
    }
}
