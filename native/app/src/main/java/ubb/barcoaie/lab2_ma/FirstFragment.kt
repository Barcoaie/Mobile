package ubb.barcoaie.lab2_ma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_read).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_readFragment)
        }

        view.findViewById<Button>(R.id.button_create).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_createFragment);
        }

        view.findViewById<Button>(R.id.button_delete).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_deleteFragmentSelect)
        }

        view.findViewById<Button>(R.id.button_update).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_updateFragmentSelect)
        }
    }
}