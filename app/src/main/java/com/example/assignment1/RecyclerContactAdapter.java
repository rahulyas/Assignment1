package com.example.assignment1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContacts;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ContactModel model = (ContactModel) arrContacts.get(position);
        holder.imgContact.setImageResource(model.img);
        holder.txtName.setText(model.Name);
        holder.txtAge.setText(model.Age);
        holder.txtAddress.setText(model.Address);
        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("imgContact",arrContacts.get(position).img);
                intent.putExtra("txtName",arrContacts.get(position).Name);
                intent.putExtra("txtAge",arrContacts.get(position).Age);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog =new Dialog(context);
                dialog.setContentView(R.layout.add_update);

                EditText edtName= dialog.findViewById(R.id.edtName);
                EditText edtAge= dialog.findViewById(R.id.edtAge);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txt=dialog.findViewById(R.id.txtTitle);

                txt.setText("Update Information");

                btnAction.setText("Update");
                edtName.setText((arrContacts.get(position)).Name);
                edtAge.setText((arrContacts.get(position)).Age);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "", age = "" , address ="";

                        if(!edtName.getText().toString().equals("")){
                            name= edtName.getText().toString();
                        } else {
                            Toast.makeText(context,"Pleace Enter Name", Toast.LENGTH_SHORT).show();
                        }

                        if(!edtAge.getText().toString().equals("")){
                            age =edtAge.getText().toString();
                        }else {
                            Toast.makeText(context,"Pleace Enter Age", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position, new ContactModel(name,age,address));
                        notifyItemChanged(position);

                        dialog.dismiss();

                    }
                });
                dialog.show();



            }
        });
        holder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtAge,txtAddress;
        ImageView imgContact,next;
        RelativeLayout relativeLayout;

        public ViewHolder(View itemView){
            super(itemView);

            txtName = itemView.findViewById(R.id.name);
            txtAge = itemView.findViewById(R.id.age);
            txtAddress =itemView.findViewById(R.id.address);
            imgContact= itemView.findViewById(R.id.imageContact);
            next=itemView.findViewById(R.id.next);
            relativeLayout= itemView.findViewById(R.id.rel_row);
        }

    }
}
