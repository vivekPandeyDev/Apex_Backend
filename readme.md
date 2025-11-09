<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Apex Gain Application</title>
    <style>
        /* Color Palette */
        :root {
            --primary-color: #2c3e50;      /* Dark Blue */
            --secondary-color: #2980b9;    /* Blue */
            --accent-color: #e67e22;       /* Orange */
            --bg-color: #ecf0f1;           /* Light Grey */
            --text-color: #2c3e50;         /* Dark Text */
            --code-bg: #34495e;            /* Dark Code Background */
            --code-color: #ecf0f1;         /* Light Code Text */
        }

        body {
            font-family: Arial, sans-serif;
            background-color: var(--bg-color);
            color: var(--text-color);
            margin: 0;
            padding: 2rem;
        }

        h1 {
            color: var(--primary-color);
            border-bottom: 2px solid var(--secondary-color);
            padding-bottom: 0.5rem;
        }

        h2 {
            color: var(--secondary-color);
            margin-top: 2rem;
        }

        ul {
            margin: 0.5rem 0 1rem 2rem;
        }

        code {
            background-color: var(--code-bg);
            color: var(--code-color);
            padding: 0.2rem 0.4rem;
            border-radius: 4px;
        }

        pre {
            background-color: var(--code-bg);
            color: var(--code-color);
            padding: 1rem;
            border-radius: 6px;
            overflow-x: auto;
        }

        .highlight {
            color: var(--accent-color);
            font-weight: bold;
        }

        li {
            margin-bottom: 0.5rem;
        }

</style>
</head>
<body>
<h1>Apex Gain Application</h1>
<p>This project is a <strong>Spring Boot application</strong> with PostgreSQL database, managed via <strong>Docker Compose</strong>.</p>
<h2>Prerequisites</h2>
<ul>
    <li>Docker ≥ 20.x</li>
    <li>Docker Compose ≥ 2.x</li>
    <li>Java 17+ (for local builds, if needed)</li>
</ul>

<h2>1. Create Docker Network</h2>
<p>Before running the application, ensure that the Docker network <code>app-net</code> exists. If it doesn’t, create it:</p>
<pre><code>docker network ls | grep app-net </code></pre>
<p>Create new docker network if not exists</p>
<pre><code>docker network create app-net</code></pre>
<p>✅ This command checks if <code>app-net</code> exists. If not, it creates the network.</p>
<p>You can verify manually:</p>
<pre><code>docker network ls</code></pre>

<h2>2. Run Docker Compose</h2>
<p>The <code>docker-compose.yml</code> file sets up all dependent services required by the application (e.g., PostgreSQL):</p>
<pre><code>docker-compose up -d</code></pre>
<ul>
    <li><code>-d</code> runs the containers in detached mode.</li>
    <li>The Spring Boot app and PostgreSQL will be connected via <code>app-net</code> network.</li>
</ul>

<h2>3. Access the Application</h2>
<p>Once the containers are running, access the Spring Boot application at:</p>
<pre><code>http://localhost:3000</code></pre>

<h2>4. Stop and Remove Containers</h2>
<pre><code>docker-compose down</code></pre>

<h2>Notes</h2>
<ul>
    <li>Ensure that no other services are using port <span class="highlight">8080</span> (or update the <code>docker-compose.yml</code> mapping).</li>
    <li>Database credentials can be configured in <code>docker-compose.yml</code> or environment variables.</li>
</ul>
</body>
</html>
