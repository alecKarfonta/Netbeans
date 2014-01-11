MarketResearchBot
=================

This program will return the average price of an item on ebay sold over the last 2 months. This was meant to give me a fairly accurate selling price on an item without having to do a lot of research. There are many bugs I could never figure out that I believe are rooted in my use of the ebay API functions.

Firstly the search has to be very specific, and it usually still returns a lot of garbage, so I had to just ignore results that were several standard deviations away from the mean.

The other major problem was that the API and ebay's website seem to return slightly different sets of data for identical search terms.

Both of these problems are probably because of the API function I call. There must be a better one, or maybe I need to do some kind of logic on the keywords before I pass them to the API. Left off in JsonArrayFunctions.java