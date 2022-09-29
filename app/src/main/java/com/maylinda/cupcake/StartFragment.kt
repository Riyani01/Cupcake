package com.maylinda.cupcake
//TODO 5b.: Dari nav_graph menuju ke StartFragment, dimana  class ini merupakan fragment pertama yang tampil pada NavHost
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.maylinda.cupcake.databinding.FragmentStartBinding
import com.maylinda.cupcake.model.OrderViewModel


class StartFragment : Fragment() {


    private var binding: FragmentStartBinding? = null


    private val sharedViewModel: OrderViewModel by activityViewModels()
    //Fungsi dibawah ini dibuat untuk digunakan pada fragment_start
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    //Fungsi dibawah ini dijalankan ketika user memilih berapa banyak cupcake yang akan dipesan
    fun orderCupcake(quantity: Int) {

        sharedViewModel.setQuantity(quantity)

        //Secara default untuk pilihan rasa disetting pada rasa Vanila
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }

         //Karena hanya memiliki satu activity saja, dengan banyak fragment di dalamnya maka tidak menggunakan Binding tetapi menggunakan navigate untuk mengarahkan ke fragment berikutnya yakni flavor fragment untuk dijalankan
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}