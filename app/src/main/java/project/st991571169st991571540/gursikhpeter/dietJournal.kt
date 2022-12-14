package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.FragmentDietJournalBinding
import androidx.lifecycle.*

class DietJournal : Fragment() {

    private lateinit var mDb:ProjectDB
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentDietJournalBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_diet_journal, container, false)

        binding.btnAdd.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_dietJournal_to_dietJournalAdd)
        }

        val applicationContext = requireNotNull(this.activity).applicationContext;
        mDb = ProjectDB.getInstance(applicationContext)


        manager = LinearLayoutManager(requireContext())

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).DietDao()

        val viewModelFactory = DietJournalViewmodelFactory(dataSource,application);

        val dietJournalViewmodel = ViewModelProviders.of(this,viewModelFactory).get(DietJournalViewmodel::class.java);

        dietJournalViewmodel.dietjournallivedatalist.observe(requireActivity(), Observer {
            binding.recyclerView.apply {
                adapter = MyRecyclerViewDiet(it)
                layoutManager = manager
            }
        })

        val urlist = arrayOf("https://www.nia.nih.gov/health/infographics/diet-and-exercise-choices-today-healthier-tomorrow",
        "https://www.webmd.com/diet/default.htm",
        "https://www.who.int/initiatives/behealthy/healthy-diet",
        "https://www.mayoclinic.org/healthy-lifestyle/fitness/in-depth/exercise/art-20048389")


        binding.dietwebview.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true;
            }
        }

        val urlchoice = (0..urlist.size-1).shuffled().last()

        binding.dietwebview.loadUrl(urlist[urlchoice])

        (activity as AppCompatActivity).supportActionBar?.title = ("Diet Journal Page")

        return binding.root
    }
}