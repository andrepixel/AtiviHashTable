import java.util.Hashtable;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Hashtable<Integer, ConsultaMedica> laudoMedico = new Hashtable<Integer, ConsultaMedica>();
        Hashtable<Integer, Paciente> infoPaciente = new Hashtable<Integer, Paciente>();
        Hashtable<Integer, Medico> infoMedico = new Hashtable<Integer, Medico>();
        int opcao = 0, contPa = 0, contMe = 0, contCM = 0;

        menu(opcao, contPa, contMe, contCM, laudoMedico, infoPaciente, infoMedico);
    }

    public static void menu(int opcao, int contPa, int contMe, int contCM,
            Hashtable<Integer, ConsultaMedica> laudoMedico, Hashtable<Integer, Paciente> infoPaciente,
            Hashtable<Integer, Medico> infoMedico) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\n______________Atividade HashTable_____________");
            System.out.println("|                                            |");
            System.out.println("|    1° - Registrar Paciente                 |");
            System.out.println("| 2° - Registrar Médico |");
            System.out.println("| 3° - Registrar Nova Consulta Médica |");
            // System.out.println("| 4° - Remove Consulta Médica |");
            // System.out.println("| 5° - Listar Consulta Médica |");
            // System.out.println("| 6° - Sair do Programa |");
            // System.out.println("|____________________________________________|");
            System.out.printf("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contPa = inserirPaciente(contPa, infoPaciente);
                    mostrarPaciente(infoPaciente);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 2:
                    contMe = inserirMedico(contMe, infoMedico);
                    mostrarMedico(infoMedico);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 3:
                    contCM = inserirConsultaMedica(opcao, contPa, contMe, contCM, infoPaciente, infoMedico, laudoMedico);
                    relatorioLaudo(laudoMedico);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                // case 4:

                // break;

                // case 5:

                // break;
            }
        } while (opcao < 6);
    }

    public static int inserirPaciente(int contPa, Hashtable<Integer, Paciente> infoPaciente) {
        Paciente paciente = new Paciente();

        contPa++;
        paciente.cadastrarPaciente(contPa);
        infoPaciente.put(contPa, paciente);

        return contPa;
    }

    public static int inserirMedico(int contMe, Hashtable<Integer, Medico> infoMedico) {
        Medico medico = new Medico();

        contMe++;
        medico.cadastrarMedico(contMe);
        infoMedico.put(contMe, medico);

        return contMe;
    }

    public static int inserirConsultaMedica(int opcao, int contPa, int contMe, int contCM,
            Hashtable<Integer, Paciente> infoPaciente, Hashtable<Integer, Medico> infoMedico,
            Hashtable<Integer, ConsultaMedica> laudoMedico) {
        Scanner scanner = new Scanner(System.in);
        ConsultaMedica consultaMedica = new ConsultaMedica();
        int valorPaciente = 0, valorMedico = 0;

        do {
            do {
                System.out.printf("\nDigite o número referente ao paciente: ");
                valorPaciente = scanner.nextInt();

                if (valorPaciente == 0) {
                    System.out.printf("\nValor inválido, digite novamente!\n");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            } while (valorPaciente == 0);

            if (valorPaciente > contPa) {
                System.out.printf("\nNão existe esse paciente nos registros, digite novamente!\n");
                System.out.printf("Registre um novo paciente, ou tente outro valor para buscar!\n");
                scanner.nextLine();
                scanner.nextLine();
                menu(opcao, contPa, contMe, contCM, laudoMedico, infoPaciente, infoMedico);
            }
        } while (valorPaciente > contPa);

        do {
            do {
                System.out.printf("\nDigite o número referente ao médico: ");
                valorMedico = scanner.nextInt();

                if (valorMedico == 0) {
                    System.out.printf("\nValor inválido, digite novamente!\n");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            } while (valorMedico == 0);

            if (valorMedico > contMe) {
                System.out.printf("\nNão existe esse médico nos registros, digite novamente!\n");
                System.out.printf("Registre um novo médico, ou tente outro valor para buscar!\n");
                scanner.nextLine();
                scanner.nextLine();
                menu(opcao, contPa, contMe, contCM, laudoMedico, infoPaciente, infoMedico);
            }
        } while (valorMedico > contMe);

        contCM++;
        consultaMedica.cadastrarConsultaMedica(contCM, valorPaciente, valorMedico);
        laudoMedico.put(contCM, consultaMedica);

        return contCM;
    }

    public static void mostrarPaciente(Hashtable<Integer, Paciente> infoPaciente) {
        for (Paciente paciente : infoPaciente.values()) {
            System.out.printf(paciente.toString());
        }
    }

    public static void mostrarMedico(Hashtable<Integer, Medico> infoMedico) {
        for (Medico medico : infoMedico.values()) {
            System.out.printf(medico.toString());
        }
    }

    public static void relatorioLaudo(Hashtable<Integer, ConsultaMedica> laudoMedico) {
        for (ConsultaMedica consultaMedica : laudoMedico.values()) {
            System.out.printf(consultaMedica.toString());
        }
    }
}