package fr.skear.skearmobile.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fr.skear.skearmobile.R;
import fr.skear.skearmobile.model.beans.Task;

/**
 * Created by booth09-mgr2 on 21/03/2017.
 */

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {


    private ArrayList<Task> members;

    //Pointeur vers une classe qui implémente OnMembersListener
    private OnMembersListener onMembersListener;


    public MembersAdapter(ArrayList<Task> members, OnMembersListener onMembersListener) {
        this.members = members;
        this.onMembersListener = onMembersListener;
    }

    /**
     * Méthode appelé par le recyclerview
     * Méthode qui permet de CREER une ligne mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_tasklist_evenement, parent, false);

        return new MembersAdapter.ViewHolder(view);
    }

    /**
     * Méthode appelé par le recyclerview
     * Méthode qui REMPLIT(AFFICHE) une ligne créée mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Task member = members.get(position);

        holder.tv_tasklisttitre.setText(member.getTitle());
        String contentAdapted = member.getContent().length() > 30 ? member.getContent().substring(0, 30) : member.getContent();
        holder.tv_tasklistdescription.setText(contentAdapted);

        // abonnement listner au click du cardview et detection de la bonne cardview cliqué
        holder.root_tasklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMembersListener != null) {
                    onMembersListener.onClick(member);
                }
            }
        });
    }

    /**
     * Méthode appelé par le recyclerview
     * Méthode qui indique le NOMBRE TOTAL de lignes à créer mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public int getItemCount() {
        return members.size();
    }

    /**
     * Classe interne représentant les pointeurs vers les composants graphiques d'une ligne de la liste
     * Il y aura une instance de cette classe par ligne
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_tasklisttitre, tv_tasklistdescription;
        // cardview
        public View root_tasklist;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_tasklisttitre = (TextView) itemView.findViewById(R.id.tv_tasklisttitre);
            tv_tasklistdescription = (TextView) itemView.findViewById(R.id.tv_tasklistdescription);
            root_tasklist = itemView.findViewById(R.id.root_tasklist);
        }
    }

    //Notre moyen de communication entre activity et adapter
    public interface OnMembersListener {
        void onClick(Task members);
    }
}
