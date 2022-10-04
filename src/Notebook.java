import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notebook {
    public static List<Contact> contatos = new ArrayList<>();
    public static List<Phone> fonesAgenda = new ArrayList<>();

    void adicionarPessoaLista(Contact contact){

        validarInformacoesObrigatoriasContato(contact);

        if(buscarContatoPorCpf(contact.getCpf()) == null) {
            contatos.add(contact);
        } else {
            System.out.println("Esse contato já existe");
        }
    }

    public Contact buscarContatoPorCpf(String cpf) {

        return contatos.stream()
                .filter(contact -> contact.getCpf().equals(cpf))
                .findAny()
                .orElse(null);

    }

    private void validarInformacoesObrigatoriasContato(Contact contact) {

        Objects.requireNonNull(contact, "Contato não pode ser nulo");
        Objects.requireNonNull(contact.getNome(), "Nome obrigatório");
        Objects.requireNonNull(contact.getSobrenome(), "Sobrenome Obrigatório");
        Objects.requireNonNull(contact.getCpf(), "CPF obrigatório");

    }

    void removerPessoaLista(Contact contact, Phone phone){

        if(buscarContatoPorCpf(contact.getCpf()) == contact) {
            contatos.remove(contact);
            fonesAgenda.remove(phone);
            Contact.getFonesContato().remove(phone);
        } else {
            System.out.println("Esse contato não existe");
        }

    }

    void adicionarTelefone(Phone phone, Contact contact){

        if (buscarContatoPorCpf(contact.getCpf()) == contact) {
            fonesAgenda.add(phone);
            Contact.getFonesContato().add(phone);
        } else {
            System.out.println("Escolha um contato válido para adicionar o telefone.");
        }
    }

    void removerTelefoneLista(Phone phone, Contact contact){

        if (buscarContatoPorCpf(contact.getCpf()) == contact) {
            fonesAgenda.remove(phone);
            Contact.getFonesContato().remove(phone);
        } else {
            System.out.println("Escolha um contato válido para remover o telefone.");
        }

    }

    void atualizarTelefoneLista(){

    }

    void atualizarPessoaLista(Contact contact){

        validarInformacoesObrigatoriasContato(contact);


    }
}
