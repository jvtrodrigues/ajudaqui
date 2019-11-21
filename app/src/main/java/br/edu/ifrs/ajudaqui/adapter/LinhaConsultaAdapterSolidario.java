package br.edu.ifrs.ajudaqui.adapter;


public class LinhaConsultaAdapterSolidario {//extends BaseAdapter
/*
    //Cria objeto LayoutInflater para ligar com a View activity_linha_solidario.xml
    private static LayoutInflater layoutInflater = null;

    List<Solidario> solidarios =  new ArrayList<>();
    SolidarioRepository solidarioRepository ;

    //Cria objeto do tipo que lista as solidarios
    private ListSolidarioActivity listarAtividades;

    //Construtor que recebe a ativida como parametro e a lista de solidarios que vai retornar do BD
    public LinhaConsultaAdapterSolidario(ListSolidarioActivity listarAtividades, List<Solidario> solidarios ) {

        this.solidarios =  solidarios;
        this.listarAtividades  =  listarAtividades;
        this.layoutInflater     = (LayoutInflater) this.listarAtividades.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        solidarioRepository   = new SolidarioRepository(listarAtividades);
    }

    //Retorna a quantidade de objetos que esta na lista
    @Override
    public int getCount(){
        return solidarios.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Método converte os valores de um item  da lista de Solidarios para uma linha do ListView
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Cria um objeto para acessar o layout activity_linha_solidario.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha_solidario,null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        TextView textViewCodigo = viewLinhaLista.findViewById(R.id.textViewCodigo);
        TextView textViewNome  =  viewLinhaLista.findViewById(R.id.textViewNome);
        TextView textViewIdentificador = viewLinhaLista.findViewById(R.id.textViewIdentificador);
        TextView textViewEmail = viewLinhaLista.findViewById(R.id.textViewEmailCad);
        TextView textViewCpf= viewLinhaLista.findViewById(R.id.textViewCpf);
        TextView textViewDataDeNascimento = viewLinhaLista.findViewById(R.id.textViewDataDeNascimento);

        Button buttonExcluir = viewLinhaLista.findViewById(R.id.buttonExcluir);
        Button buttonEditar = viewLinhaLista.findViewById(R.id.buttonEditar);

        textViewCodigo.setText(String.valueOf(solidarios.get(position).get_id()));
        textViewNome.setText(solidarios.get(position).getNome());
        textViewIdentificador.setText(solidarios.get(position).getIdentificador());
        textViewEmail.setText(solidarios.get(position).getEmail());
        textViewCpf.setText(solidarios.get(position).getCpf());
        textViewDataDeNascimento.setText(solidarios.get(position).getDataDeNascimento());

        //Criando evento para excluir um registro do BD
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "Registro excluído com sucesso!";
                Integer retorno = solidarioRepository.delete(solidarios.get(position).get_id());
                if(retorno == 0)
                    mensagem = "Erro ao excluir registro!";
                Toast.makeText(listarAtividades, mensagem, Toast.LENGTH_LONG).show();
                atualizaLista();
            }
        });

        //Criando evento para editar um registro do BD
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listarAtividades, EditSolidarioActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("_id",solidarios.get(position).get_id());
                listarAtividades.startActivity(intent);
            }
        });
        return viewLinhaLista;
    }

    //atualizando a lista após excluir registro
    public void atualizaLista(){
        this.solidarios.clear();
        this.solidarios = solidarioRepository.getAll();
        this.notifyDataSetChanged();
    }*/
}