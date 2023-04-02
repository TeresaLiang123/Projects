We send a GET request to get the home page's cookies in order to log into
Fakebook. Once we are logged in we are at the page after logging in and have the html
of the page. With the html info, we are able to gather all the links on the page.
We gather these lists because we need to go through all links to find the hidden flags.
Once we are tranfered to a new page and are given the html from the responses, the links
in the new page is added to the list of links we need to crawl. To make sure we are not
going to a link more than once, we make sure the list of links in the html or page we
are currently on is not already visited. we have a variable that keeps track of all visited
links to help with that. Once we have received all 5 flags, we are done.

The challenges we face were trying to log in and figuring out how to crawl through
all the links in each page. Another challenge is trying to get the flags at a faster
run time.

We tested code by printing out the requests we are making and the responses for them.
This helped debug whether we are sending he right data or not. Some of those data
is the session id and csrf tokens. We use the printing method to debug and identify
certain values of variables to help see what is storing correctly and what isn't.