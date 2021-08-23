#!/usr/bin/python
import csv
import random
import datetime

records=400000
print("Making %d records\n" % records)

fieldnames=['userid','username','bondid','bondname','price', 'date']

 
writer = csv.DictWriter(open("bond.csv", "w"), fieldnames=fieldnames)



userList = [[1, "张三"],[2,"勇哥"],[3,"鹏哥"]]
bondList = [[1, "证券A"],[2,"证券B"],[3,"证券C"],[4,"证券D"],[5,"证券E"]]

start_date = datetime.date(2020, 1, 1)
end_date = datetime.date(2020, 12, 22)



for i in range(0, records):
  user = random.choice(userList)
  bond = random.choice(bondList)

  time_between_dates = end_date - start_date
  days_between_dates = time_between_dates.days
  random_number_of_days = random.randrange(days_between_dates)
  random_date = start_date + datetime.timedelta(days=random_number_of_days)




  writer.writerow(dict([
    ('userid', user[0]),
    ('username', user[1]),
    ('bondid', bond[0]),
    ('bondname', bond[1]),
    ('price', str(random.randint(1000,9000))),
    ('date', random_date)
    ]))
