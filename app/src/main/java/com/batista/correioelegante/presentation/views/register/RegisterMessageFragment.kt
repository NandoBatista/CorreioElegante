package com.batista.correioelegante.presentation.views.register

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
=======
import androidx.appcompat.app.AppCompatActivity
>>>>>>> 41c6dd34c527f10a0d9c07147ec368298a17e166
import androidx.navigation.fragment.findNavController
import com.batista.correioelegante.R
import com.batista.correioelegante.databinding.FragmentRegisterMessageBinding


class RegisterMessageFragment : Fragment() {

<<<<<<< HEAD
    private var _binding: FragmentRegisterMessageBinding? = null
    private val binding: FragmentRegisterMessageBinding get() = _binding!!
    private val Fragment.packageManager get() = activity?.packageManager
//    private var viewModel = ViewModelProvider(this)[RegisterMessageViewModel::class.java]


=======
    private var _binding: RegisterMessageFragment? = null
    @Suppress("UnusedPrivateMember")
    private val binding: RegisterMessageFragment = _binding!!
>>>>>>> 41c6dd34c527f10a0d9c07147ec368298a17e166

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRegisterMessageBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSendEmail.setOnClickListener {

            val email = binding.inputlayoutEmail.text.toString()
            val subject = binding.inputlayoutNameOrNickname.text.toString()
            val message = binding.inputlayoutSurprise.text.toString()

            val addresses = email.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {

                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, addresses)
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)

            }
            if (packageManager?.resolveActivity(intent, 0) != null) {
                startActivity(intent)
                findNavController().navigate(R.id.action_registerMessageFragment_to_confirmationMailFragment)
            } else {
                val intentException = Intent(
                    Intent.ACTION_VIEW, Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.google.android.gm"
                    )
                )
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_app_not_installed),
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(intentException)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}