package br.edu.ifrs.ajudaqui.adapter;


public class LinhaConsultaAdapterOng  {//extends BaseAdapter
/*
    //Cria objeto LayoutInflater para ligar com a View activity_linha.xml
    private static LayoutInflater layoutInflater = null;

    List<Ong> ongs =  new ArrayList<>();
    OngRepository ongRepository ;

    //Cria objeto do tipo que lista as ongs
    private ListOngActivity listarAtividades;

    //Construtor que recebe a ativida como parametro e a lista de ongs que vai retornar do BD
    public LinhaConsultaAdapterOng(ListOngActivity listarAtividades, List<Ong> ongs ) {

        this.ongs =  ongs;
        this.listarAtividades  =  listarAtividades;
        this.layoutInflater     = (LayoutInflater) this.listarAtividades.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ongRepository   = new OngRepository(listarAtividades);
    }

    //Retorna a quantidade de objetos que esta na lista
    @Override
    public int getCount(){
        return ongs.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Método converte os valores de um item  da lista de Ongs para uma linha do ListView
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Cria um objeto para acessar o layout activity_linha.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha,null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        TextView textViewCodigo = viewLinhaLista.findViewById(R.id.textViewCodigo);
        TextView textViewNome  =  viewLinhaLista.findViewById(R.id.textViewNome);
        TextView textViewIdentificador = viewLinhaLista.findViewById(R.id.textViewIdentificador);
        TextView textViewEmail = viewLinhaLista.findViewById(R.id.textViewEmailCad);
        TextView textViewSite = viewLinhaLista.findViewById(R.id.textViewSite);
        TextView textViewArea = viewLinhaLista.findViewById(R.id.textViewArea);
        TextView textViewCep= viewLinhaLista.findViewById(R.id.textViewCpf);
        TextView textViewRua = viewLinhaLista.findViewById(R.id.textViewRua);
        TextView textViewNum = viewLinhaLista.findViewById(R.id.textViewDataDeNascimento);

        Button buttonExcluir = viewLinhaLista.findViewById(R.id.buttonExcluir);
        Button buttonEditar = viewLinhaLista.findViewById(R.id.buttonEditar);

        textViewCodigo.setText(String.valueOf(ongs.get(position).get_id()));
        textViewNome.setText(ongs.get(position).getNome());
        textViewIdentificador.setText(ongs.get(position).getIdentificador());
        textViewEmail.setText(ongs.get(position).getEmail());
        textViewSite.setText(ongs.get(position).getEnderecoWeb());
        textViewArea.setText(ongs.get(position).getArea().getDesc());
        textViewCep.setText(ongs.get(position).getCep());
        textViewRua.setText(ongs.get(position).getRua());
        textViewNum.setText(ongs.get(position).getNumero());

        //Criando evento para excluir um registro do BD
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "Registro excluído com sucesso!";
                Integer retorno = ongRepository.delete(ongs.get(position).get_id());
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
                Intent intent = new Intent(listarAtividades, EditOngActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("_id",ongs.get(position).get_id());
                listarAtividades.startActivity(intent);
            }
        });
        return viewLinhaLista;
    }

    //atualizando a lista após excluir registro
    public void atualizaLista(){
        this.ongs.clear();
        this.ongs = ongRepository.getAll();
        this.notifyDataSetChanged();
    }*/
}