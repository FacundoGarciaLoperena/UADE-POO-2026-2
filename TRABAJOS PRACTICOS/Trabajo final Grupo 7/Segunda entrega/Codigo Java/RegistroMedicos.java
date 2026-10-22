import java.util.ArrayList;

public class RegistroMedicos {
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public void agregar(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Faltan los datos del medico.");
        }
        for (Medico actual : medicos) {
            if (actual.getMatricula().equals(medico.getMatricula())
                    || actual.getDni().equals(medico.getDni())) {
                throw new IllegalArgumentException("Ya existe ese medico o matricula.");
            }
        }
        medicos.add(medico);
    }

    public Medico buscarPorMatricula(String matricula) {
        for (Medico medico : medicos) {
            if (medico.getMatricula().equals(matricula)) {
                return medico;
            }
        }
        return null;
    }

    public ArrayList<Medico> listar() {
        return new ArrayList<Medico>(medicos);
    }
}
