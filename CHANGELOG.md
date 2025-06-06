# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.03.25

### Added

- Designed abstract class for Depth Chart component

### Updated

- Changed design to include:
  -numPlayers to return the number of players on the roster
  -printOffensive/DefensivePersonnel to print the lineups given a certain personnel
  - addPlayers to add an array of Players to a given position.

## 2025.01.31

### Added

<<<<<<< Updated upstream
<<<<<<< Updated upstream

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07

## 2025.04.09

### Added

- Designed kernel implementation for Depth Chart component

### Updated

- Changed design to include constructor, kernel methods, and iterator

## [2024.01.31]

- Completed component brainstorming

## [2025.02.20]

- Completed component proof-of-concept
- Added a DepthChart.java class to prove the functionality of a DepthChart
component
- Made addPlayer, removePlayer, numPosition, and an iterator for the component
- Proved functionality by creating a team and then printing the first player at
each position to show that the starting lineup could be printed
=======
- Designed a Depth Chart component
- Designed a Golf Leaderboard component
- Designed a PR Tracker component

>>>>>>> Stashed changes
=======

- Designed a Depth Chart component
- Designed a Golf Leaderboard component
- Designed a PR Tracker component

>>>>>>> Stashed changes
