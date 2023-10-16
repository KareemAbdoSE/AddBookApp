# AddBookApp

Address Book Application
Welcome to the Address Book Application, a web-based platform for managing contacts and their information.

Overview
This application allows users to maintain an address book containing their contacts' information such as name, phone number, and address. It offers functionalities like adding new contacts, updating existing ones, fetching all contacts, and deleting them.

Features
Display Contacts: View all contacts in a tabulated format.
Add New Contact: Easily add a new contact to the address book.
Update Contact: Modify details of an existing contact.
Delete Contact: Remove a contact from the address book.
Live Demo
Access the live application hosted on Azure at:
https://kareemabdoapp-new.azurewebsites.net/

API Endpoints
For developers and users who want to interact with the backend directly, you can use the following main API endpoint:
https://kareemabdoapp-new.azurewebsites.net/addressBooks

Available Operations:
GET: Fetch all contacts.
POST: Add a new contact. Ensure the JSON structure matches the BuddyInfo entity format.
PUT /addressBooks/{id}: Update an existing contact by its ID.
DELETE /addressBooks/{id}: Delete a contact by its ID.
