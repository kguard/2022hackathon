package com.kguard.hackathon.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)
        val sign= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestId() //id 불러오기
            .build()
        googleSignInClient= GoogleSignIn.getClient(requireActivity(),sign)
        binding.googleLogin.setOnClickListener{
            signInGoogle()
        }
        firebaseAuth= FirebaseAuth.getInstance()
        return binding.root
    }
    fun signInGoogle(){
        val signIntent= googleSignInClient.signInIntent
        launcher.launch(signIntent)

    }
    private var launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult() ){
            result ->
        if (result.resultCode == Activity.RESULT_OK)
        {
            val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResult(task)
        }
    }
    private fun handleResult(task: Task<GoogleSignInAccount>) {
        if(task.isSuccessful){
            val account=task.result
            if(account!=null){
                updateUI(account)
            }
        }
    }
    private fun updateUI(account: GoogleSignInAccount) {
        val credential= GoogleAuthProvider.getCredential(account.idToken,null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                findNavController().navigate(R.id.action_loginFragment_to_nameFragment)
            }
            else{
                Toast.makeText(context,it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }


}