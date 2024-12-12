import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> listaCompras = new ArrayList<>();
    public static void main(String[] args) {
        //5. Crie um programa que permita ao utilizador adicionar itens a uma lista de compras (utilizando ArrayList). O
        //programa deve pedir novos itens até que o utilizador insira "sair". Crie opções para inserir novos elementos,
        //editar um elemento, eliminar um elemento e mostrar a lista. Sugere-se a utilização de um menu.

        int opcao = -1;
        while (opcao != 0){
            Scanner in = new Scanner(System.in);
            System.out.println("1.Inserir novos elementos");
            System.out.println("2.Editar um elemento");
            System.out.println("3.Eliminar um elemento");
            System.out.println("4.Mostrar lista");
            System.out.println("0.Sair");
            if (in.hasNextInt()){
                opcao = in.nextInt();
            }
            else{
                System.out.println("Opção inválida");
            }
            if (opcao == 0) return;
            else if (opcao == 1) InserirElementos();
            else if (opcao == 2) EditarElemento();
            else if (opcao == 3) EliminarElemento();
            else if (opcao == 4) MostrarLista();
            else System.out.println("Opção inválida");
        }
    }

    private static void InserirElementos(){
        while (true){
            System.out.println("Insira um elemento para a lista de compras. Digite 'sair' para sair.");
            String elemento = in.nextLine();
            if (elemento.equals("sair") || elemento.equals("Sair")) return;
            else listaCompras.add(elemento);
        }
    }

    private static void EditarElemento(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual elemento deseja editar?");
        MostrarLista();
        System.out.println("0. Voltar");
        int opcao = 0;
        if (in.hasNextInt()){
            opcao = (in.nextInt()-1);
            if (opcao == -1) return;
            if (opcao > (listaCompras.size()-1)){
                System.out.println("Opção inválida");
                EditarElemento();
            }
        }else{
            System.out.println("Opção inválida");
            EditarElemento();
        }

        System.out.println("Editar "+listaCompras.get(opcao)+" para:");
        in = new Scanner(System.in);
        listaCompras.remove(opcao);
        listaCompras.add(opcao,in.nextLine());
    }

    private static void EliminarElemento(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual elemento deseja eliminar?");
        MostrarLista();
        System.out.println("0. Voltar");
        int opcao = 0;
        if (in.hasNextInt()){
            opcao = (in.nextInt()-1);
            if (opcao == -1) return;
            if (opcao > (listaCompras.size()-1)){
                System.out.println("Opção inválida");
                EliminarElemento();
            }
        }else{
            System.out.println("Opção inválida");
            EliminarElemento();
        }
        System.out.println(listaCompras.get(opcao)+" foi eliminado.");
        listaCompras.remove(opcao);
    }

    private static void MostrarLista(){
        for (int i = 0; i < listaCompras.size(); i++){
            System.out.println((i+1)+". "+listaCompras.get(i));
        }
        System.out.println();
    }
}