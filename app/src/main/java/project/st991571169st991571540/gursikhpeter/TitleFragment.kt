package project.st991571169st991571540.gursikhpeter

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import project.st991571169st991571540.gursikhpeter.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    private lateinit var mDb: ProjectDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment, container, false
        )

        setHasOptionsMenu(true)

        mDb = ProjectDB.getInstance(requireActivity())

        binding.btnEx.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_exerciseHome)
        }

        binding.btnFood.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_dietJournal)
        }

        binding.btnabout.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_aboutFragment)
        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.title) {
            var i = Intent(android.provider.Settings.ACTION_SETTINGS)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }

        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)

    }

}