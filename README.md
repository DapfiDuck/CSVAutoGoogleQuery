# CSV Auto Google Query

This research tool takes input from a .csv file and pipes 5 cells each to the standart browser after pasting it into a google query.

## Application
Large research projects in which you continuously need to copy-paste cells into a google search bar.

## Functionality
You first select the file to be opened, then you enter the Separation character (, and ; are conventional in csv, TAB in tsv) and then the Collumn you want to read in the Excel format (A, B, C, [...], AA, AB etc). Last enter the starting row, your browser should now open 5 tabs with one google query each and a a window asking you to resume should pop up. Click *yes* to open the next 5 Tabs, *no* or *cancel* to close the program. Note, that atm the program might crash if you tried to access a Collumn that does not exist/the row hasn't been written on that far.
