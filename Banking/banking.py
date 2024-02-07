import os

class Bank:
    def __init__(self):
        pass

    def deposit(self, user_account, amount):
        if self.validate_account(user_account):
            user_account.balance += amount
            user_account.update_account_file()
            print(f"${amount} added to your account\nNow the total is ${user_account.balance}")
        else:
            print("Invalid account credentials")

    def withdraw(self, user_account, amount):
        if self.validate_account(user_account):
            if user_account.balance >= amount:
                user_account.balance -= amount
                user_account.update_account_file()
                print(f"${amount} removed from your account\nNow the total is ${user_account.balance}")
            else:
                print("Not enough funds in your account")
        else:
            print("Invalid account credentials")

    def show(self, user_account):
        if self.validate_account(user_account):
            print(f"Balance in your account: ${user_account.balance}")
        else:
            print("Invalid account credentials")

    def validate_account(self, user_account):
        try:
            file_path = f"{user_account.account_no}_{user_account.name}.txt"
            if os.path.exists(file_path):
                with open(file_path, 'r') as file:
                    stored_data = file.readline().strip().split(',')
                    stored_pin = int(stored_data[0])
                    stored_balance = float(stored_data[1])
                if stored_pin == user_account.pin:
                    user_account.balance = stored_balance
                    return True
            return False
        except FileNotFoundError:
            return False


class Account:
    def __init__(self, name, account_no, pin) -> None:
        self.name = name
        self.account_no = account_no
        self.pin = pin
        self.balance = 0

    def newacc(self):
        file_path = f"{self.account_no}_{self.name}.txt"
        if not os.path.isfile(file_path):
            with open(file_path, 'w') as file:
                file.write(f"{self.pin},{self.balance}\n")

    def delete_account(self):
        file_path = f"{self.account_no}_{self.name}.txt"
        try:
            os.remove(file_path)
            return "Account deleted."
        except FileNotFoundError:
            return "Account not found."

    def update_account_file(self):
        file_path = f"{self.account_no}_{self.name}.txt"
        with open(file_path, 'w') as file:
            file.write(f"{self.pin},{self.balance}\n")

def get_user_input():
    account_name = input("Enter the bank holder's full name: ")
    account_no = int(input("Enter the holder's bank account number: "))
    pin = int(input(f"Enter {account_name}'s PIN: "))
    return account_name, account_no, pin

def interface():
    bank_instance = Bank()

    while True:
        try:
            print("What do you want to do?")
            print("1. Deposit\n2. Withdraw\n3. Check Balance\n4. Create Account\n5. Delete Account\n6. Exit")
            choice = int(input("Enter your choice (1-6): "))

            if choice == 1:
                account_name, account_no, pin = get_user_input()
                amount = float(input("Enter the amount to be deposited: $"))
                user_account = Account(account_name, account_no, pin)
                bank_instance.deposit(user_account, amount)

            elif choice == 2:
                account_name, account_no, pin = get_user_input()
                amount = float(input("Enter the amount to be Withdrawn: $"))
                user_account = Account(account_name, account_no, pin)
                bank_instance.withdraw(user_account, amount)

            elif choice == 3:
                account_name, account_no, pin = get_user_input()
                user_account = Account(account_name, account_no, pin)
                bank_instance.show(user_account)

            elif choice == 4:
                account_name = input("Enter your name: ")
                account_number = int(input("Enter your account number: "))
                account_pin = int(input("Enter your PIN: "))
                new_account = Account(account_name, account_number, account_pin)
                new_account.newacc()
                print("Account created.")

            elif choice == 5:
                account_name, account_no, pin = get_user_input()
                user_account = Account(account_name, account_no, pin)
                result = user_account.delete_account()
                print(result)

            elif choice == 6:
                print("Exiting the program.")
                break

            else:
                print("Invalid choice. Please enter a number between 1 and 6.")

        except ValueError:
            print("Invalid input. Please enter a number.")

if __name__ == "__main__":
    interface()
