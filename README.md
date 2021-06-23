# QuickWiki
App follows an MVVM pattern
"adapters" contain adapters of recycler views and fragment tabs
"fragment" contain all the fragment load files including the "data" file that contains all the data classes
layout starting with "tab_" are fragment tab layouts
layout starting with "rv_" are recycler view Views
"Singleton" conatins elements that ensures network and database ,single instance property
OfflineMode is the part that is responsible for showing the downloaded data

The app has many bugs ,most of which i could find and others because of depriciation files
bugs :-\n
1]"[WARN] Incremental annotation processing requested, but support is disabled because the following pro"\n
    couldnt find anything to resolve this bug.\n
    thus conmented the whole code for database attachment.\n
2]Category List and featured images succesfully fetch data from api but loads very slow(might be because of the data size)\n
3]couldnt find how to load text from api response of articles ,I can load the data but couldnt make sense of Xwiki format text\n
