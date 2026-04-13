💳 Credit Approval Workflow with Camunda 8 + Java
Overview

This project implements a credit approval system using:

Camunda 8 (Zeebe) for workflow orchestration
Java (Spring Boot) for business logic
BPMN for process modeling
DMN for decision automation
FEEL for decision expressions

The system simulates a real-world fintech credit approval pipeline, including:

Automated scoring
Decision evaluation
Manual review flow
Result persistence
Email notification
🧠 Architecture

The system follows a process orchestration architecture:

Camunda (Zeebe) → controls workflow execution
Spring Boot services → execute business logic
Workers → handle tasks asynchronously
Database (JPA) → persist requests and results
🔄 Workflow (BPMN)

Main flow:

Start credit request
Calculate score
Evaluate decision (DMN)
Gateway:
Approved → send email → end
Rejected → end
Review → manual approval → final decision
⚖Decision Logic (DMN)
Score	Decision
> 70	Approved
50–69	Review
< 50	Rejected
🧩 Features
✔️ BPMN workflow orchestration
✔️ DMN decision engine
✔️ FEEL expressions
✔️ Java workers (Zeebe)
✔️ Manual review (User Task)
✔️ Email integration (SendGrid)
✔️ Idempotent result handling
✔️ Persistent state with JPA
🛠️ Tech Stack
Java 21
Spring Boot
Camunda 8 (Zeebe)
MYSQL
Docker
BPMN / DMN / FEEL

▶️ Running the Project
1. Start Camunda Platform
   docker compose up -d
2. Run the Spring Boot app
   ./mvnw spring-boot:run
   🧪 Example Request
   {
   "name": "Rudi",
   "income": 5000,
   "age": 30
   }
   📈 Learning Goals

This project demonstrates:

Process orchestration vs business logic separation
Scalable workflow design
Handling real-world scenarios (review, retries, decisions)
Integration between Camunda and Java
🚀 Future Improvements
Add Kafka (event-driven architecture)
Improve observability (logs, metrics)
Add authentication (OAuth2)
Externalize secrets
Add retry/backoff strategies
👨‍💻 Author: Kudilson Paulo Garcia

Built as part of a journey to becoming a Camunda Architect 🚀