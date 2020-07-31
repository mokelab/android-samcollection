package com.mokelab.demo.samcollection.jetpack.arch.room

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.mokelab.demo.binding.BindingFragment
import com.mokelab.demo.samcollection.R
import com.mokelab.demo.samcollection.databinding.JetpackRoomCreateFragmentBinding
import com.mokelab.demo.samcollection.model.article.Article
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JetpackRoomCreateFragment: BindingFragment<JetpackRoomCreateFragmentBinding>(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var viewModel: JetpackRoomBasicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProviders.of(requireActivity()).get(JetpackRoomBasicViewModel::class.java)

        setHasOptionsMenu(true)
    }

    override fun onCreateViewDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): JetpackRoomCreateFragmentBinding {
        val binding = JetpackRoomCreateFragmentBinding.inflate(inflater, container, false)
        return binding
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_done, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_done -> {
            this.submit()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun submit() {
        try {
            launch {
                withContext(Dispatchers.IO) {
                    val title = binding.title ?: ""
                    val content = binding.content ?: ""
                    val article = Article(0, title, content)
                    viewModel.dao.insert(article)
                }
                Navigation.findNavController(requireView()).popBackStack()
            }
        } catch (e: Exception) {
            Snackbar.make(requireView(), "Failed to insert", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        val service = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager ?: return
        service.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}