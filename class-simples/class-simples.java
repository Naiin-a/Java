
import java.time.LocalDate;
import java.time.Period;

    public class aluno {
        private String nome;
        private LocalDate datadenascimento;

        public aluno (String nome, LocalDate datadenascimento){
            this.nome = nome;
            this.datadenascimento = datadenascimento;

        }
        public String getNome(){
            return nome;

        }
        public void setNome(String nome){
            this.nome = nome;

        }
        public LocalDate getDatadenascimento(){
            return datadenascimento;

        }
        public void setDatadenascimento(LocalDate datadenascimento){
            this.datadenascimento = datadenascimento;

        }
        public  int calculaIdade(){
            return Period.between(this.datadenascimento,LocalDate.now()).getYears();
        }


    }
