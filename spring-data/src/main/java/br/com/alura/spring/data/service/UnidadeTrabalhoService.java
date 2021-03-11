package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private Boolean system = true;

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void executar(Scanner scanner){
        int action;
        while (system){
            System.out.println("Menu de unidades de trabalho");
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
        System.out.println("Descrição da unidade");
        String descricao, endereco;
        do {
            descricao = scanner.nextLine();
        }while (descricao.isEmpty());

        System.out.println("Endereço da unidade");
        do {
            endereco = scanner.nextLine();
        }while (endereco.isEmpty());

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println(unidadeTrabalho.getDescricao()+" Salvo!!");
    }

    public void editarById(Scanner scanner) {
        System.out.println("Qual id da unidade");
        long id = scanner.nextInt();

        Optional<UnidadeTrabalho> optional = unidadeTrabalhoRepository.findById(id);

        if(optional.isPresent()){
            UnidadeTrabalho unidadeTrabalho = optional.get();

            System.out.println("Descrição atual: "+unidadeTrabalho.getDescricao());
            System.out.println("Nova descição: ");

            String descricao;//Gambiarra para ver se para de salvar vazio
            do {
                descricao = scanner.nextLine();
            }while (descricao.isEmpty());

            System.out.println("Endereo atual: "+unidadeTrabalho.getEndereco());
            System.out.println("Nova endereço: ");

            String endereco;//Gambiarra para ver se para de salvar vazio
            do {
                endereco = scanner.nextLine();
            }while (endereco.isEmpty());

            unidadeTrabalho.setDescricao(descricao);
            unidadeTrabalho.setEndereco(endereco);
            unidadeTrabalhoRepository.save(unidadeTrabalho);
            System.out.println("Registro atualizado");
        }else
            System.out.println("unidade nao encontrado");
    }

    public void visualizar(Scanner scanner) {
        System.out.println("Qual id da unidade");
        long id = scanner.nextInt();

        Optional<UnidadeTrabalho> optional = unidadeTrabalhoRepository.findById(id);

        if(optional.isPresent()){
            UnidadeTrabalho unidadeTrabalho = optional.get();

            System.out.println("Descrição atual: "+unidadeTrabalho.getDescricao()+" endereço atual: "+unidadeTrabalho.getEndereco());
        }else
            System.out.println("unidade nao encontrado");
    }

    public void visualizarTodos(Scanner scanner) {
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach(unidade -> System.out.println(unidade.getDescricao()+ " endereço "+unidade.getEndereco()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Qual id da unidade");
        long id = scanner.nextInt();

        Optional<UnidadeTrabalho> optional = unidadeTrabalhoRepository.findById(id);

        if(optional.isPresent()){
            unidadeTrabalhoRepository.delete(optional.get());
            System.out.println("deletado");
        }else
            System.out.println("unidade nao encontrado");
    }
}
