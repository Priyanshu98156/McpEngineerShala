package com.priyanshu.mcpengineershala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhijeet.todolist.dataclases.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.priyanshu.mcpengineershala.adapter.TeacherChat
import com.priyanshu.mcpengineershala.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    lateinit var binding:ActivityChatBinding
    var receiverUid : String=""
    var senderuid : String =""
    lateinit var chat : TeacherChat
    lateinit var messagesList : ArrayList<Message>
    var receiverRoom : String =""
    var senderRoom: String =""
    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var myreference: DatabaseReference = database.getReference("StudentChat")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        messagesList = ArrayList()

        receiverUid= intent.getStringExtra("uid").toString()
        senderuid = FirebaseAuth.getInstance().currentUser?.uid.toString()

        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        var profilepi = intent.getStringExtra("profilepic").toString()

        senderRoom =  receiverUid + senderuid
        receiverRoom= senderuid + receiverUid

        println("Iddddddddddd")
        println(receiverRoom)
        println(senderRoom)

        binding.username.text=name.toString()
        binding.email.text=email.toString()
        chat = TeacherChat(this@ChatActivity,messagesList)
        binding.recyclerView.layoutManager= LinearLayoutManager(this@ChatActivity)
        binding.recyclerView.adapter=chat
        myreference.child(senderRoom).child("message").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                messagesList.clear()
                for (information in snapshot.children){
                    var chatting = information.getValue(Message::class.java)
                    if (chatting!=null){
                        messagesList.add(chatting)
                        println("messages $chatting")
                    }

                    chat.notifyDataSetChanged()

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        binding.etMessage.doOnTextChanged { text, start, before, count ->
            binding.sendButton.visibility= View.VISIBLE
        }
        binding.sendButton.setOnClickListener {
            var senderid = myreference.push().key.toString()
            var message = Message(binding.etMessage.text.toString(),senderuid,senderid)
            var receiverid = myreference.push().key.toString()
            var messageR = Message(binding.etMessage.text.toString(),senderuid,receiverid)
            myreference.child(senderRoom).child("message").child(senderid).setValue(message).addOnCompleteListener {
                if (it.isSuccessful){
                    myreference.child(receiverRoom).child("message").child(receiverid).setValue(messageR).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this, "Sent Successfully", Toast.LENGTH_SHORT).show()
                            binding.etMessage.text.clear()
                        }
                    }
                }
            }
        }

    }
}