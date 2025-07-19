Bookmarker application that supports adding, deleting, and viewing bookmarks created using Spring.

## How to run the application
### Using Docker
1. Make sure you have Docker installed on your machine.
2. Clone the repo.
3. Navigate to the project root directory.
4. Run the following command in the terminal:
   ```bash
   ./run.sh start
   ```
5. To stop the application, run:
   ```bash
   ./run.sh stop
   ```
6. To set up only the database, run:
   ```bash
   ./run.sh setup_infra
   ./run.sh stop_infra
   ```
### For local development
1. Set up a database using the step above.
2. Set profile to "local" in "Edit Configurations" in IntelliJ.
3. Run the application using the main class ` BookmarkerApplication`.
