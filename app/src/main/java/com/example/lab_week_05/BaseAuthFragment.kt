package com.example.lab_week_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BaseAuthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class BaseAuthFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser

        if (currentUser == null) {
            redirectToLogin()
        } else if (isUserBlocked()) {
            redirectToLogin()
        }
    }
    private fun isUserBlocked(): Boolean {
        return false
    }
    private fun redirectToLogin() {
        findNavController().navigate(R.id.loginFragment)
    }
}