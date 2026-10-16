# AGENTS.md — Java Project Instructions

## 1. Scope and Workspace Restrictions

- Work exclusively within the current project's root directory and its subdirectories.
- Never create, modify, delete, or move files outside the project directory.
- Never access unrelated repositories, private directories, SSH keys, credentials, or system configuration.
- Never execute commands that modify the host system.
- Never install system-wide software or modify global configuration.
- Never use `sudo`.
- Never modify files in the user's home directory.
- Temporary files must be created inside the project directory.
- If a task requires access outside the project directory, stop and request explicit permission.

## 2. Git Restrictions

The human developer retains full control over Git operations.

### Allowed

- `git status`
- `git diff`
- `git log`
- `git show`
- `git branch --list`
- `git diff --check`

### Forbidden without explicit permission

- `git add`
- `git commit`
- `git push`
- `git pull`
- `git fetch`
- `git merge`
- `git rebase`
- `git reset`
- `git checkout`
- `git switch`
- `git cherry-pick`
- `git stash`
- `git clean`
- Creating or deleting branches or tags
- Creating, approving, or merging pull requests
- Creating releases or triggering deployments
- Modifying Git remotes or Git configuration

Never perform automatic commits or pushes.

Never modify `.git/` or Git hooks.

Do not bypass these restrictions through scripts, IDE integrations, GitHub CLI, APIs, or other tools.

## 3. Development Principles

- Follow the existing project architecture and coding conventions.
- Prefer simple, readable, maintainable solutions.
- Do not introduce unnecessary abstractions or dependencies.
- Avoid overengineering.
- Apply SOLID principles where appropriate.
- Respect existing package structures.
- Keep methods small and focused.
- Prefer constructor injection over field injection.
- Use meaningful class, method, and variable names.
- Avoid wildcard imports.
- Never suppress warnings without justification.
- Do not modify unrelated code.
- Do not perform large refactorings unless explicitly requested.

## 4. Java Standards

- Use the Java version configured in the project.
- Follow existing formatting conventions.
- Prefer immutable data structures where appropriate.
- Use `final` where it improves clarity.
- Use records for suitable immutable data carriers.
- Use `Optional` primarily for return values.
- Avoid returning `null` from collection-returning methods.
- Use appropriate exception types.
- Never silently swallow exceptions.
- Use SLF4J for application logging where available.
- Never log passwords, tokens, credentials, or sensitive information.

## 5. Testing Standards

- Use the project's existing testing framework.
- Prefer JUnit 5 and AssertJ where available.
- New test methods must follow this naming convention:

  `<methodName>_whenXXX_thenYYY`

- Use AssertJ for assertions.
- Each test method must contain exactly one top-level assertion invocation.
- Custom assertion helpers may internally contain multiple AssertJ assertions.
- Cover normal behavior, edge cases, and error conditions.
- Do not remove existing tests to make a build pass.
- Do not weaken assertions to hide failures.
- Do not modify production code solely to accommodate an incorrect test.

## 6. Build and Validation

- Prefer the existing Maven or Gradle wrapper.
- Run relevant tests after making changes.
- Run the full test suite when appropriate.
- Do not skip tests unless explicitly requested.
- Do not modify build configuration merely to bypass failures.
- Do not automatically update dependencies or plugins.
- Do not download or execute arbitrary remote scripts.
- Keep build artifacts inside the project directory whenever possible.

## 7. Security

- Treat all project data as confidential.
- Never transmit source code, project files, or credentials to external services unless explicitly authorized.
- Never read or modify `.env`, secret stores, credentials, or private keys unless explicitly required and authorized.
- Never introduce hardcoded secrets.
- Never disable security controls.
- Never execute destructive commands without explicit approval.
- Never execute downloaded code without explicit approval.

## 8. File Operations

- Modify only files necessary for the requested task.
- Preserve existing file encodings and line endings.
- Never delete files without explicit permission.
- Never overwrite unrelated user changes.
- Never modify generated files unless the task explicitly requires it.
- Never modify IDE settings without permission.
- Never create files outside the project workspace.

## 9. Task Execution

For every development task:

1. Understand the requested change.
2. Inspect relevant existing code.
3. Identify affected components.
4. Implement the smallest reasonable solution.
5. Add or update relevant tests.
6. Run applicable validation commands.
7. Review the resulting diff.
8. Report the outcome to the human developer.

If requirements are ambiguous or a decision would significantly affect the architecture, ask before proceeding.

## 10. Completion Report

After completing a task, provide:

- Summary of changes
- Modified and created files
- Tests executed and their results
- Remaining issues or limitations
- Any decisions requiring human review

Do not commit, push, deploy, or publish the changes.

## 11. Human Control

The human developer is responsible for:

- Git staging and commits
- Branch management
- Pull requests
- Code review and approval
- Merging
- Releases
- Deployments
- Infrastructure and system configuration

These instructions apply to all tasks unless the human developer explicitly authorizes an exception.

**Default behavior: implement locally, validate locally, report results, and stop.**