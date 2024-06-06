[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]
<a name="readme-top"></a>

<br />
<div align="center">
<h3 align="center">Book cataloging REST api</h3>

  <p align="center">
    Simple REST api for book catalogue management build on a Spring framework.
    <br />
    <a href="https://github.com/mateuszmarc/Workshop5"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/mateuszmarc/Workshop5">View Demo</a>
    ·
    <a href="https://github.com/mateuszmarc/Workshop5/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/mateuszmarc/Workshop5/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#implementation">Implementation</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
<a href="#usage">Usage</a>
      <ul>
        <li><a href="#displaying-all-tasks">Retrieving all books</a></li>
        <li><a href="#adding-the-task">Adding the book</a></li>
        <li><a href="#closing-the-task">Updating the book</a></li>
        <li><a href="#deleting-the-task">Deleting the book</a></li>
      </ul>
</li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#thoughts-and-future-extensions">Thoughts and future extensions</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

As I said before, it is just a simple book catalogue management api created to practise Spring framework and REST api.
This api allows the user to retrieve all books as well as to add, update and delete the book.
Books are stored in local server memory. 

### Built With

* [![Java][Java.com]][Java-url]
* [![ApacheTomcat][ApacheTomcat.com]][ApacheTomcat-url]
* [![Spring][Spring.com]][Spring-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Implementation
This api specifies the way we can communicate with server:

[![API description][api-description]](images/api-description.png)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

You don't need much to use this api but below might help
* IDE, for example: [Intellij](https://www.jetbrains.com/idea/).

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/mateuszmarc/Workshop5.git
   ```
2. Build server on Tomcat.

3. Set application context to "/".

4. Run Tomcat server to use api.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage
Run Tomcat server to use api.

See detailed api documentation click in the link: 
https://documenter.getpostman.com/view/27635486/2sA3XJjQCX


See the [open issues](https://github.com/mateuszmarc/Workshop5/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Mateusz Marcykiewicz - mmarcykiewicz@gmail.com

Project Link: [https://github.com/mateuszmarc/Workshop5](https://github.com/mateuszmarc/Workshop5)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Thoughts and future extensions
Project helped me to practice a Spring framework and REST api implementation. 
I used https://www.postman.com/ to create documentation and test api. 
I provided also [api-requests] to easily test api through IDE. 
In the future instead of storing a list of books in a local server memory, it would 
be good to store data in a database. 

And adding tests for application is what I will do next for this project.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mateuszmarc/Workshop5.svg?style=for-the-badge
[contributors-url]: https://github.com/mateuszmarc/Workshop5/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mateuszmarc/Workshop5.svg?style=for-the-badge
[forks-url]: https://github.com/mateuszmarc/Workshop5/network/members
[stars-shield]: https://img.shields.io/github/stars/mateuszmarc/Workshop5.svg?style=for-the-badge
[stars-url]: https://github.com/mateuszmarc/Workshop5/stargazers
[issues-shield]: https://img.shields.io/github/issues/mateuszmarc/Workshop5.svg?style=for-the-badge
[issues-url]: https://github.com/mateuszmarc/Workshop5/issues
[license-shield]: https://img.shields.io/github/license/mateuszmarc/Workshop5.svg?style=for-the-badge
[license-url]: https://github.com/mateuszmarc/Workshop5/blob/main/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/mateusz-marcykiewicz/
[product-screenshot]: images/task-example.png
[api-description]: src/screenshots/api-communication-guide.png
[api-requests]: api-requests.http

[Java.com]: https://img.shields.io/badge/Java-000?style=for-the-badge&&logoColor=white
[Java-url]: https://www.java.com/pl/

[ApacheTomcat.com]: https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black
[ApacheTomcat-url]: https://tomcat.apache.org/

[Spring.com]: https://img.shields.io/badge/Spring-6DB33F%2F?style=for-the-badge&logo=spring&logoColor=6DB33F&labelColor=white&color=white

[Spring-url]: https://spring.io/projects/spring-framework
