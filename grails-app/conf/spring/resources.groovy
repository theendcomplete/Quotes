import com.theendcomplete.quotes.QuoteService

// Place your Spring DSL code here
beans = {
    quoteService(QuoteService) { bean ->
        bean.autowire = 'byName'
    }
}
