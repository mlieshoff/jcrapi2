# jcrapi2
A Java Wrapper For Official Supercell Clash Royal Api 

## Continuous integration

https://travis-ci.org/mlieshoff/jcrapi2

## Working Agreement

1. Get a ticket
* Assign it to you
* Move it in the projects board from "To Do" to "In Progress" 
2. Create a branch: issue<ticket number>_<small_description>
3. Implement your changes, do TDD!
* Reformat the code with the projects formatter (intellij_code_formatter.xml)
* Analyze the changed files with the projects inspection rules (intellij_inspection_rules.xml)
* Commit with message like: [Issue<ticket_number>] <your message>
4. Create a pull request as fast as possible, base it to master
* Name it like: [Issue<ticket_number>] <your message>
* Put label WIP
5. You're done if:
* All tests are green (old and new ones)
* Code coverage is 100%
* Build system is also okay with compiling and tests, check pull request mergeability
* Remove label WIP
6. Shift the ticket to done into the projects board
7. Do "Squash and Merge" in your pull request
8. Copy the pull requests link to your ticket as close comment and close the ticket
9. Shift the ticket to merged in the projects board
10. If you have to update from master:
a) use merge not rebase

### Testing
1. Create an end to end test
2. Create an integration test
3. Create an unit test