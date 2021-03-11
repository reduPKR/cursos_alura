package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private Boolean system = true;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void executar(Scanner scanner){
        int action;
        while (system){
            System.out.println("Menu de funcionarios");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar por id");
            System.out.println("4 - Visualizar todos");
            System.out.println("5 - Deletar");

            action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    editarById(scanner);
                    break;
                case 3:
                    visualizar(scanner);
                    break;
                case 4:
                    visualizarTodos(scanner);
                    break;
                case 5:
                    deletar(scanner);
                    break;
                default:
                    system = !system;
                    break;
            }
        }
    }

    public void salvar(Scanner scanner) {
        String nome, cpf;
        double salario;

        System.out.println("Nome do funcionario");
        do {
            nome = scanner.nextLine();
        }while (nome.isEmpty());

        System.out.println("cpf ");
        do {
            cpf = scanner.nextLine();
        }while (cpf.isEmpty());

        System.out.println("salario ");
        salario = scanner.nextDouble();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContatacao(LocalDateTime.now());

        funcionarioRepository.save(funcionario);

        System.out.println(funcionario.getNome()+" Salvo!!");
    }

    public void editarById(Scanner scanner) {
        System.out.println("Qual id do funcionario");
        long id = scanner.nextInt();

        Optional<Funcionario> optional = funcionarioRepository.findById(id);

        if(optional.isPresent()){
            Funcionario funcionario = optional.get();

            String nome, cpf;
            double salario;

            System.out.println("Nome ataual "+funcionario.getNome());
            System.out.println("Novo nome "+funcionario.getNome());
            do {
                nome = scanner.nextLine();
            }while (nome.isEmpty());

            System.out.println("Cpf ataual "+funcionario.getCpf());
            System.out.println("Novo cpf "+funcionario.getCpf());
            do {
                cpf = scanner.nextLine();
            }while (cpf.isEmpty());

            System.out.println("salario ");
            salario = scanner.nextDouble();

            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setSalario(salario);

            funcionarioRepository.save(funcionario);

            System.out.println("Registro atualizado");
        }else
            System.out.println("funcionario nao encontrado");
    }

    public void visualizar(Scanner scanner) {
        System.out.println("Qual id da funcionario");
        long id = scanner.nextInt();

        Optional<Funcionario> optional = funcionarioRepository.findById(id);

        if(optional.isPresent()){
            Funcionario funcionario = optional.get();

            System.out.println(funcionario.getNome()+ " "+funcionario.getCpf()+" "+funcionario.getSalario());
        }else
            System.out.println("funcionario nao encontrado");
    }

    public void visualizarTodos(Scanner scanner) {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario ->
                System.out.println(funcionario.getNome()+ " "+funcionario.getCpf()+" "+funcionario.getSalario()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Qual id do funcionario");
        long id = scanner.nextInt();

        Optional<Funcionario> optional = funcionarioRepository.findById(id);

        if(optional.isPresent()){
            funcionarioRepository.delete(optional.get());
            System.out.println("deletado");
        }else
            System.out.println("funcionario nao encontrado");
    }
}
