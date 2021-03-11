package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private Boolean system = true;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void executar(Scanner scanner){
        int action;
        while (system){
            System.out.println("Menu de cargos");
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
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);

        System.out.println(cargo.getDescricao()+" Salvo!!");
    }

    public void editarById(Scanner scanner) {
        System.out.println("Qual id do cargo");
        long id = scanner.nextInt();

        Optional<Cargo> optional = cargoRepository.findById(id);

        if(optional.isPresent()){
            Cargo cargo = optional.get();

            System.out.println("Descrição atual: "+cargo.getDescricao());
            System.out.println("Nova descição: ");

            String descricao;//Gambiarra para ver se para de salvar vazio
            do {
                descricao = scanner.nextLine();
            }while (descricao.isEmpty());

            cargo.setDescricao(descricao);
            cargoRepository.save(cargo);
            System.out.println("Registro atualizado");
        }else
            System.out.println("Cargo nao encontrado");
    }

    public void visualizar(Scanner scanner) {
        System.out.println("Qual id do cargo");
        long id = scanner.nextInt();

        Optional<Cargo> optional = cargoRepository.findById(id);

        if(optional.isPresent()){
            Cargo cargo = optional.get();

            System.out.println("Descrição atual: "+cargo.getDescricao());
        }else
            System.out.println("Cargo nao encontrado");
    }

    public void visualizarTodos(Scanner scanner) {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo.getDescricao()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Qual id do cargo");
        long id = scanner.nextInt();

        Optional<Cargo> optional = cargoRepository.findById(id);

        if(optional.isPresent()){
            cargoRepository.delete(optional.get());
            System.out.println("deletado");
        }else
            System.out.println("Cargo nao encontrado");
    }
}
