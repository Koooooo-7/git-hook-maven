# git-hook-maven

> An automatically install git hook practicable sample in maven.

## How to use

- Clone this repo, you can treat it as a simple project of you.
- Run either `mvn clean package` or `mvn clean install` like other mvn project.
- Now, `git commit` any changes, you should find it will auto run `mvn test` as the `pre-commit` hook.

## How does it work

It just simply rewrite the `.git/hooks/<hook>.sample` to `.git/hooks/<hook>` and write custom hook content (`mvn test`) into it.
It will be triggerred on `mvn clean` phase via the `exec-maven-plugin`.

The git hook script `GitHook.java` located in `/githook`.
You can do the trick on your own projects now. :dog:
