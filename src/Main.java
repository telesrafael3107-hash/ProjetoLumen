import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String nomeUsuario;
    static String cpfUsuario;
    static String telefoneUsuario;
    static String emailUsuario;
    static String senhaUsuario;

    static ArrayList<Reserva> reservas = new ArrayList<>();
    static ArrayList<Evento> eventos = new ArrayList<>();

    static class Reserva {

        String tipo;
        String item;
        int quantidade;
        String data;
        String horaInicio;
        String horaFim;
        String usuario;

        Reserva(String tipo, String item, int quantidade,
                String data, String horaInicio,
                String horaFim, String usuario) {

            this.tipo = tipo;
            this.item = item;
            this.quantidade = quantidade;
            this.data = data;
            this.horaInicio = horaInicio;
            this.horaFim = horaFim;
            this.usuario = usuario;
        }
    }

    static class Evento {

        String nome;
        String data;
        String horario;
        String local;
        String descricao;
        String criador;

        Evento(String nome, String data, String horario,
               String local, String descricao,
               String criador) {

            this.nome = nome;
            this.data = data;
            this.horario = horario;
            this.local = local;
            this.descricao = descricao;
            this.criador = criador;
        }
    }

    public static void main(String[] args) {

        System.out.println("Bem-vindo ao Lumen!");

        iniciarSistema();

        scanner.close();
    }

    // menu

    static void iniciarSistema() {

        while (true) {

            System.out.println("\nBem-vindo!");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    criarConta();
                    return;

                case 2:
                    fazerLogin();
                    return;

                case 3:
                    System.out.println("\nAté logo!");
                    return;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    // criar conta

    static void criarConta() {

        System.out.println("\nCriando sua conta...");

        System.out.print("Nome completo: ");
        nomeUsuario = scanner.nextLine();

        System.out.print("CPF: ");
        cpfUsuario = scanner.nextLine();

        System.out.print("Telefone: ");
        telefoneUsuario = scanner.nextLine();

        System.out.print("E-mail: ");
        emailUsuario = scanner.nextLine();

        System.out.print("Crie uma senha: ");
        senhaUsuario = scanner.nextLine();

        System.out.println("\nConta criada com sucesso!");
        System.out.println("Olá, " + nomeUsuario + "!");

        // Depois de criar a conta,
        // o usuário já entra no sistema.
        menuPrincipal();
    }

    // login

    static void fazerLogin() {

        if (cpfUsuario == null) {

            System.out.println("\nVocê ainda não possui uma conta.");
            System.out.println("Escolha a opção 'Criar conta' no menu inicial.");

            iniciarSistema();
            return;
        }

        while (true) {

            System.out.println("\nLogin");

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("E-mail: ");
            String email = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (cpf.equals(cpfUsuario)
                    && telefone.equals(telefoneUsuario)
                    && email.equals(emailUsuario)
                    && senha.equals(senhaUsuario)) {

                System.out.println("\nLogin realizado com sucesso!");
                System.out.println("Olá, " + nomeUsuario + "!");

                menuPrincipal();
                return;

            } else {

                System.out.println("\nCPF, telefone, e-mail ou senha incorretos.");

                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Voltar");

                System.out.print("Escolha: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 2) {
                    iniciarSistema();
                    return;
                }
            }
        }
    }

    // menu principa

    static void menuPrincipal() {

        while (true) {

            System.out.println("\nMenu principal");
            System.out.println("Olá, " + nomeUsuario + "!");
            System.out.println();

            System.out.println("1 - Eventos");
            System.out.println("2 - Espaços");
            System.out.println("3 - Recursos");
            System.out.println("4 - Sair");

            System.out.print("\nO que você deseja fazer? ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    menuEventos();
                    break;

                case 2:
                    menuEspacos();
                    break;

                case 3:
                    menuRecursos();
                    break;

                case 4:
                    System.out.println("\nObrigado por utilizar o sistema, "
                            + nomeUsuario + "!");
                    return;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    // menu de eventos

    static void menuEventos() {

        while (true) {

            System.out.println("\nEventos");

            System.out.println("1 - Ver eventos");
            System.out.println("2 - Criar evento");
            System.out.println("3 - Ver meus eventos");
            System.out.println("4 - Voltar");

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    verEventos();
                    break;

                case 2:
                    criarEvento();
                    break;

                case 3:
                    verMeusEventos();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    // ver eventos

    static void verEventos() {

        System.out.println("\nEventos disponíveis");

        System.out.println("\n1 - Culto de Domingo");
        System.out.println("   Data: 20/09/2026");
        System.out.println("   Horário: 19:00");
        System.out.println("   Local: Igreja Principal");

        System.out.println("\n2 - Encontro de Jovens");
        System.out.println("   Data: 25/09/2026");
        System.out.println("   Horário: 20:00");
        System.out.println("   Local: Salão Paroquial");

        System.out.println("\n3 - Reunião de Líderes");
        System.out.println("   Data: 28/09/2026");
        System.out.println("   Horário: 19:30");
        System.out.println("   Local: Sala de Reuniões");

        System.out.println("\n4 - Voltar");

        System.out.print("\nEscolha um evento: ");
        int evento = scanner.nextInt();
        scanner.nextLine();

        if (evento == 1) {

            System.out.println("\nCulto de Domingo");
            System.out.println("Data: 20/09/2026");
            System.out.println("Horário: 19:00");
            System.out.println("Local: Igreja Principal");
            System.out.println("Descrição: Culto semanal da igreja.");

        } else if (evento == 2) {

            System.out.println("\nEncontro de Jovens");
            System.out.println("Data: 25/09/2026");
            System.out.println("Horário: 20:00");
            System.out.println("Local: Salão Paroquial");
            System.out.println("Descrição: Encontro semanal dos jovens.");

        } else if (evento == 3) {

            System.out.println("\nReunião de Líderes");
            System.out.println("Data: 28/09/2026");
            System.out.println("Horário: 19:30");
            System.out.println("Local: Sala de Reuniões");
            System.out.println("Descrição: Reunião dos líderes da igreja.");

        } else if (evento == 4) {

            return;

        } else {

            System.out.println("\nEvento não encontrado.");
        }
    }

    // criar um evento

    static void criarEvento() {

        System.out.println("\nCriar novo evento");

        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();

        System.out.print("Data: ");
        String data = scanner.nextLine();

        System.out.print("Horário: ");
        String horario = scanner.nextLine();

        System.out.print("Local: ");
        String local = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Evento novoEvento = new Evento(
                nome,
                data,
                horario,
                local,
                descricao,
                nomeUsuario
        );

        eventos.add(novoEvento);

        System.out.println("\nEvento criado com sucesso!");
    }

    // ver meus eventos

    static void verMeusEventos() {

        System.out.println("\nMeus eventos");

        boolean encontrou = false;

        for (Evento evento : eventos) {

            if (evento.criador.equals(nomeUsuario)) {

                encontrou = true;

                System.out.println("\nEvento: " + evento.nome);
                System.out.println("Data: " + evento.data);
                System.out.println("Horário: " + evento.horario);
                System.out.println("Local: " + evento.local);
                System.out.println("Descrição: " + evento.descricao);
            }
        }

        if (!encontrou) {

            System.out.println("\nVocê ainda não criou nenhum evento.");
        }
    }

    // menu de espaços

    static void menuEspacos() {

        while (true) {

            System.out.println("\nEspaços");

            System.out.println("1 - Consultar espaços");
            System.out.println("2 - Reservar um espaço");
            System.out.println("3 - Ver minhas reservas");
            System.out.println("4 - Voltar");

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    consultarEspacos();
                    break;

                case 2:
                    reservarEspaco();
                    break;

                case 3:
                    verReservasEspacos();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    // consultar espaços

    static void consultarEspacos() {

        System.out.println("\nEspaços disponíveis");

        System.out.println("1 - Igreja Principal");
        System.out.println("2 - Salão Paroquial");
        System.out.println("3 - Sala da Catequese");
        System.out.println("4 - Sala de Reuniões");
        System.out.println("5 - Auditório");
        System.out.println("6 - Sala dos Jovens");

        System.out.print("\nQual espaço você deseja consultar? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        switch (opcao) {

            case 1:
                System.out.println("Igreja Principal");
                System.out.println("Capacidade: 250 pessoas");
                System.out.println("Descrição: Espaço principal para cultos, missas e grandes celebrações.");
                break;

            case 2:
                System.out.println("Salão Paroquial");
                System.out.println("Capacidade: 120 pessoas");
                System.out.println("Descrição: Espaço amplo para confraternizações, festas e encontros.");
                break;

            case 3:
                System.out.println("Sala da Catequese");
                System.out.println("Capacidade: 30 pessoas");
                System.out.println("Descrição: Sala destinada a aulas de catequese e pequenos grupos.");
                break;

            case 4:
                System.out.println("Sala de Reuniões");
                System.out.println("Capacidade: 20 pessoas");
                System.out.println("Descrição: Sala tranquila para reuniões de equipes e lideranças.");
                break;

            case 5:
                System.out.println("Auditório");
                System.out.println("Capacidade: 80 pessoas");
                System.out.println("Descrição: Espaço com cadeiras e estrutura para palestras e apresentações.");
                break;

            case 6:
                System.out.println("Sala dos Jovens");
                System.out.println("Capacidade: 40 pessoas");
                System.out.println("Descrição: Sala usada para encontros, estudos e atividades dos jovens.");
                break;

            default:
                System.out.println("Espaço não encontrado.");
        }
    }

    // reservar espaços

    static void reservarEspaco() {

        System.out.println("\nReservar um espaço");

        System.out.println("1 - Igreja Principal");
        System.out.println("2 - Salão Paroquial");
        System.out.println("3 - Sala da Catequese");
        System.out.println("4 - Sala de Reuniões");
        System.out.println("5 - Auditório");
        System.out.println("6 - Sala dos Jovens");

        System.out.print("Escolha o espaço: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String espaco;

        switch (opcao) {

            case 1:
                espaco = "Igreja Principal";
                break;

            case 2:
                espaco = "Salão Paroquial";
                break;

            case 3:
                espaco = "Sala da Catequese";
                break;

            case 4:
                espaco = "Sala de Reuniões";
                break;

            case 5:
                espaco = "Auditório";
                break;

            case 6:
                espaco = "Sala dos Jovens";
                break;

            default:
                System.out.println("Espaço inválido.");
                return;
        }

        fazerReservaEspaco(espaco);
    }

    // fazer a reserva do espaço

    static void fazerReservaEspaco(String espaco) {

        System.out.println("\nVocê escolheu: " + espaco);

        System.out.print("Data da reserva: ");
        String data = scanner.nextLine();

        System.out.print("Horário de início: ");
        String horaInicio = scanner.nextLine();

        System.out.print("Horário de término: ");
        String horaFim = scanner.nextLine();

        // verifica se o espaço já está reservado

        for (Reserva reserva : reservas) {

            if (reserva.tipo.equals("Espaço")
                    && reserva.item.equals(espaco)
                    && reserva.data.equals(data)
                    && horariosConflitam(
                    reserva.horaInicio,
                    reserva.horaFim,
                    horaInicio,
                    horaFim)) {

                System.out.println("\nEsse espaço já está reservado nesse horário.");
                System.out.println("Escolha outro horário.");
                return;
            }
        }

        Reserva novaReserva = new Reserva(
                "Espaço",
                espaco,
                1,
                data,
                horaInicio,
                horaFim,
                nomeUsuario
        );

        reservas.add(novaReserva);

        System.out.println("\nReserva realizada com sucesso!");
        System.out.println("Espaço: " + espaco);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horaInicio + " até " + horaFim);
    }

    // ver reservas dos espaços

    static void verReservasEspacos() {

        System.out.println("\nMinhas reservas de espaços");

        boolean encontrou = false;

        for (Reserva reserva : reservas) {

            if (reserva.tipo.equals("Espaço")
                    && reserva.usuario.equals(nomeUsuario)) {

                encontrou = true;

                System.out.println("\nEspaço: " + reserva.item);
                System.out.println("Data: " + reserva.data);
                System.out.println("Horário: "
                        + reserva.horaInicio
                        + " até "
                        + reserva.horaFim);
            }
        }

        if (!encontrou) {

            System.out.println("\nVocê ainda não possui reservas de espaços.");
        }
    }

    // menu recusos

    static void menuRecursos() {

        while (true) {

            System.out.println("\nRecursos");

            System.out.println("1 - Consultar recursos");
            System.out.println("2 - Reservar um recurso");
            System.out.println("3 - Ver minhas reservas");
            System.out.println("4 - Voltar");

            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    consultarRecursos();
                    break;

                case 2:
                    reservarRecurso();
                    break;

                case 3:
                    verReservasRecursos();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }

    // consultar recursos

    static void consultarRecursos() {

        System.out.println("\nRecursos disponíveis");

        System.out.println("1 - Microfone - 6 unidades");
        System.out.println("2 - Caixa de som - 4 unidades");
        System.out.println("3 - Projetor - 2 unidades");
        System.out.println("4 - Notebook - 3 unidades");
        System.out.println("5 - Cadeiras - 150 unidades");
        System.out.println("6 - Mesas - 20 unidades");
        System.out.println("7 - Tripé para microfone - 5 unidades");

        System.out.print("\nQual recurso você deseja consultar? ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        switch (opcao) {

            case 1:
                System.out.println("Microfone");
                System.out.println("Quantidade disponível: 6");
                break;

            case 2:
                System.out.println("Caixa de som");
                System.out.println("Quantidade disponível: 4");
                break;

            case 3:
                System.out.println("Projetor");
                System.out.println("Quantidade disponível: 2");
                break;

            case 4:
                System.out.println("Notebook");
                System.out.println("Quantidade disponível: 3");
                break;

            case 5:
                System.out.println("Cadeiras");
                System.out.println("Quantidade disponível: 150");
                break;

            case 6:
                System.out.println("Mesas");
                System.out.println("Quantidade disponível: 20");
                break;

            case 7:
                System.out.println("Tripé para microfone");
                System.out.println("Quantidade disponível: 5");
                break;

            default:
                System.out.println("Recurso não encontrado.");
        }
    }

    // reservar recurso

    static void reservarRecurso() {

        System.out.println("\nReservar um recurso");

        System.out.println("1 - Microfone - 6 unidades");
        System.out.println("2 - Caixa de som - 4 unidades");
        System.out.println("3 - Projetor - 2 unidades");
        System.out.println("4 - Notebook - 3 unidades");
        System.out.println("5 - Cadeiras - 150 unidades");
        System.out.println("6 - Mesas - 20 unidades");
        System.out.println("7 - Tripé para microfone - 5 unidades");

        System.out.print("Escolha o recurso: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String recurso;
        int quantidadeTotal;

        switch (opcao) {

            case 1:
                recurso = "Microfone";
                quantidadeTotal = 6;
                break;

            case 2:
                recurso = "Caixa de som";
                quantidadeTotal = 4;
                break;

            case 3:
                recurso = "Projetor";
                quantidadeTotal = 2;
                break;

            case 4:
                recurso = "Notebook";
                quantidadeTotal = 3;
                break;

            case 5:
                recurso = "Cadeiras";
                quantidadeTotal = 150;
                break;

            case 6:
                recurso = "Mesas";
                quantidadeTotal = 20;
                break;

            case 7:
                recurso = "Tripé para microfone";
                quantidadeTotal = 5;
                break;

            default:
                System.out.println("Recurso inválido.");
                return;
        }

        System.out.println("\nRecurso escolhido: " + recurso);
        System.out.println("Quantidade total: " + quantidadeTotal);

        System.out.print("Quantas unidades você deseja reservar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade <= 0) {

            System.out.println("\nA quantidade deve ser maior que zero.");
            return;
        }

        if (quantidade > quantidadeTotal) {

            System.out.println("\nNão temos essa quantidade disponível.");
            System.out.println("Quantidade máxima: " + quantidadeTotal);
            return;
        }

        System.out.print("Data da reserva: ");
        String data = scanner.nextLine();

        System.out.print("Horário de início: ");
        String horaInicio = scanner.nextLine();

        System.out.print("Horário de término: ");
        String horaFim = scanner.nextLine();

        // Calcula quantos recursos já estão reservados para o mesmo horário
        int quantidadeReservada = 0;

        for (Reserva reserva : reservas) {

            if (reserva.tipo.equals("Recurso")
                    && reserva.item.equals(recurso)
                    && reserva.data.equals(data)
                    && horariosConflitam(
                    reserva.horaInicio,
                    reserva.horaFim,
                    horaInicio,
                    horaFim)) {

                quantidadeReservada += reserva.quantidade;
            }
        }

        int quantidadeRestante =
                quantidadeTotal - quantidadeReservada;

        if (quantidade > quantidadeRestante) {

            System.out.println("\nNão há recursos suficientes nesse horário.");
            System.out.println("Quantidade total: " + quantidadeTotal);
            System.out.println("Já reservados: " + quantidadeReservada);
            System.out.println("Ainda disponíveis: " + quantidadeRestante);

            return;
        }

        Reserva novaReserva = new Reserva(
                "Recurso",
                recurso,
                quantidade,
                data,
                horaInicio,
                horaFim,
                nomeUsuario
        );

        reservas.add(novaReserva);

        System.out.println("\nReserva realizada com sucesso!");
        System.out.println("Recurso: " + recurso);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horaInicio + " até " + horaFim);
    }

    // ver reserva de recursos

    static void verReservasRecursos() {

        System.out.println("\nMinhas reservas de recursos");

        boolean encontrou = false;

        for (Reserva reserva : reservas) {

            if (reserva.tipo.equals("Recurso")
                    && reserva.usuario.equals(nomeUsuario)) {

                encontrou = true;

                System.out.println("\nRecurso: " + reserva.item);
                System.out.println("Quantidade: " + reserva.quantidade);
                System.out.println("Data: " + reserva.data);
                System.out.println("Horário: "
                        + reserva.horaInicio
                        + " até "
                        + reserva.horaFim);
            }
        }

        if (!encontrou) {

            System.out.println("\nVocê ainda não possui reservas de recursos.");
        }
    }

    // verificação dos horários

    static boolean horariosConflitam(
            String inicioExistente,
            String fimExistente,
            String novoInicio,
            String novoFim) {

        int inicio1 = converterHora(inicioExistente);
        int fim1 = converterHora(fimExistente);

        int inicio2 = converterHora(novoInicio);
        int fim2 = converterHora(novoFim);

        return inicio2 < fim1 && fim2 > inicio1;
    }

    // converter

    static int converterHora(String hora) {

        String[] partes = hora.split(":");

        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        return horas * 60 + minutos;
    }
}