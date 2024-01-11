//package com.example.animalsworldapp.data.cache.fake
//
//import com.example.animalsworldapp.domain.models.FaunaDomain
//import com.example.animalsworldapp.domain.models.FloraDomain
//import java.util.UUID
//
//class FakeData {
//    companion object {
//        fun fakeFaunaDomainAll() = listOf(
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Mammal",
//                name = "Giraffe",
//                backgroundImage = "https://polinka.top/uploads/posts/2023-05/1684576793_polinka-top-p-zhivotnie-afriki-kartinki-instagram-37.jpg",
//                image = "https://gas-kvas.com/grafic/uploads/posts/2023-09/1695804676_gas-kvas-com-p-kartinki-zhiraf-31.jpg",
//                interestingFact = "# The giraffe’s scientific name, Giraffa camelopardalis , comes from the ancient Greeks’ belief that it looked like a camel wearing a leopard’s coat.\uD83E\uDD23\n" +
//                        "# There are four species of giraffes: Northern giraffe, Southern giraffe, Masai giraffe, and reticulated giraffe.\n" +
//                        "group of giraffes is called a “",
//                aboutFauna = "The giraffe is a large African hoofed mammal belonging to the genus Giraffa. It is the tallest living terrestrial animal and the largest ruminant on Earth. Traditionally, giraffes were thought to be one species, Giraffa camelopardalis, with nine subspecies. Most recently, researchers proposed dividing them into up to eight extant species due to new research into their mitochondrial and nuclear DNA, as well as morphological measurements. Seven other extinct species of Giraffa are known from the fossil record.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Mammal",
//                name = "Elephant",
//                backgroundImage = "https://pic.rutubelist.ru/video/dd/f0/ddf0b926f3d0261c7989c6cb7c3241f0.jpg?width=900",
//                image = "https://abc-decor.com/img/gallery/12/thumbs/thumb_l_PL6057.jpg",
//                interestingFact = "Elephants can spend up to 18 hours a day eating and grazing.\n" +
//                        "Their trunks can suck and store about two gallons of water.\n" +
//                        "Elephants can pick up sound vibrations from 50 miles away.\n" +
//                        "Their skin is about one inch thick.",
//                aboutFauna = "Elephants are the largest living land animals. Three living species are currently recognised: the African bush elephant, the African forest elephant, and the Asian elephant. They are the only surviving members of the family Elephantidae and the order Proboscidea; extinct relatives include mammoths and mastodons. ",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Mammal",
//                name = "Lion",
//                backgroundImage = "https://i.pinimg.com/736x/3e/ac/a6/3eaca6a78cd5a037258d6a5a31e2465e.jpg",
//                image = "https://kartinki.pics/uploads/posts/2022-03/1646134899_28-kartinkin-net-p-lvenok-kartinki-31.jpg",
//                interestingFact = "African lions are the most social of all big cats and live together in groups or “prides.” Although extremely large prides, consisting of up to 30 individuals, have been observed, the average pride consists of five or six females, their cubs of both sexes, and one or two males (known as a coalition if more than one) who mate with the adult females.\n" +
//                        "\n" +
//                        "Lions live for about 10-14 years in the wild. While in captivity they live for as long as 20-25 years old.",
//                aboutFauna = "The lion (Panthera leo) is a large cat of the genus Panthera native to Africa and India. It has a muscular, broad-chested body; short, rounded head; round ears; and a hairy tuft at the end of its tail. It is sexually dimorphic; adult male lions are larger than females and have a prominent mane. It is a social species, forming groups called prides. A lion's pride consists of a few adult males, related females, and cubs.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Bird",
//                name = "Eagle",
//                backgroundImage = "https://s1.1zoom.ru/b4945/547/Birds_Hawk_ferruginous_hawk_Black_background_Tree_574860_2048x2732.jpg",
//                image = "https://images.wallpapersden.com/image/download/eagle-bird-predator_aWVtaZSZmpqtpaSklGduaGetZ25oZw.jpg",
//                interestingFact = "The eagle has always been considered as the king of birds, on account of its great strength, rapidity and elevation of flight, natural ferocity, and the terror it inspires into its fellows of the air.\n" +
//                        "\n" +
//                        "There are more than 60 different species of eagle.\n" +
//                        "\n",
//                aboutFauna = "Eagle is the common name for the golden eagle, bald eagle, and other birds of prey in the family Accipitridae. Eagles belong to several groups of genera, some of which are closely related. True eagles comprise the genus Aquila.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Bird",
//                name = "Pelican",
//                backgroundImage = "https://i.pinimg.com/originals/ed/89/59/ed89590355c0dccaff535dcbebd1e12d.jpg",
//                image = "https://laplaya-rus.ru/wp-content/uploads/a/6/7/a670c3e92186ebd01482418455530594.jpeg",
//                interestingFact = "Pelicans have an impressive ability to store large amounts of water in their pouches, which can hold up to three gallons - " +
//                        "an amount that is two to three times greater than the capacity of their stomachs.\n Pelicans are fascinating creatures, with their large, distinctive pouches used to catch fish and rainwater for drinking.",
//                aboutFauna = "Pelicans (genus Pelecanus) are a genus of large water birds that make up the family Pelecanidae. They are characterized by a long beak and a large throat pouch used for catching prey and draining water from the scooped-up contents before swallowing. They have predominantly pale plumage, except for the brown and Peruvian pelicans. The bills, pouches, and bare facial skin of all pelicans become brightly coloured before the breeding season.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Fish",
//                name = "Dolphin",
//                backgroundImage = "https://i.pinimg.com/originals/82/11/94/82119482adacd02e19c280aeca44bb6b.jpg",
//                image = "https://novikovnn.ru/wp-content/uploads/b/6/5/b655af48c0f6e08e6d63502780b2890e.jpeg",
//                interestingFact = "There are approximately 40 different species. Dolphins come in a variety of colors, including white, grey, blue, black, and even pink\n" +
//                        "The smallest type of dolphin is 3-4 feet long, while the largest is 30 feet long!",
//                aboutFauna = "A dolphin is an aquatic mammal within the infraorder Cetacea. Dolphin species belong to the families Delphinidae (the oceanic dolphins), Platanistidae (the Indian river dolphins), Iniidae (the New World river dolphins), Pontoporiidae (the brackish dolphins), and possibly extinct Lipotidae (baiji or Chinese river dolphin). There are 40 extant species named as dolphins.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Fish",
//                name = "Shark",
//                backgroundImage = "https://i.pinimg.com/736x/d6/67/15/d667154006f5c0094e300b8fd321f4f7--scenery-kind.jpg",
//                image = "https://yt3.googleusercontent.com/ytc/AGIKgqPNFnhLD6rvDFVZ5QUq_vEbZKC8uMv49PqzerVB=s900-c-k-c0x00ffffff-no-rj",
//                interestingFact = "Sharks use heartbeats to follow their prey. Sharks have nodules on the nose called ampullae of Lorenzini. They can sense electricity with these nodules, therefore the electrical pulse that comes from a beating heart acts like a signal for close by sharks.\n" +
//                        "\n" +
//                        "No one can see their ears, and that doesn’t stop them from being able to hear us from more than 2 football fields away. That’s because sharks have inner ears only, using them they can track the sound of the prey from a distance of 800 feet or more.",
//                aboutFauna = "Sharks are a group of elasmobranch fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head. Modern sharks are classified within the clade Selachimorpha (or Selachii) and are the sister group to the Batoidea (rays and kin). Some sources extend the term \"shark\" as an informal category including extinct members of Chondrichthyes (cartilaginous fish) with a shark-like morphology, such as hybodonts. ",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Fish",
//                name = "Whale",
//                backgroundImage = "https://blog.cwf-fcf.org/wp-content/uploads/2020/03/baby-humpback-whale-1920-530x640.jpg",
//                image = "https://miro.medium.com/v2/resize:fit:2400/1*s4-Klm75_SbT8n-yFi-JXQ.jpeg",
//                interestingFact = "Whales are fascinating creatures, and one of the most interesting facts about them is that they can't breathe through their mouths. This is because the mouth of a whale is connected directly to its stomach, meaning that air cannot pass through it. This is why whales must come to the surface of the water to breathe, as they have blowholes on the top of their heads which allow them to take in air.",
//                aboutFauna = "Whales are a widely distributed and diverse group of fully aquatic placental marine mammals. As an informal and colloquial grouping, they correspond to large members of the infraorder Cetacea, i.e. all cetaceans apart from dolphins and porpoises.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Reptile",
//                name = "Chameleon",
//                backgroundImage = "https://klubmama.ru/uploads/posts/2022-08/1661656293_41-klubmama-ru-p-podelka-presmikayushchiesya-foto-54.jpg",
//                image = "https://img.goodfon.ru/original/3840x2160/3/20/khameleon-zelenyi-morda-portret-vzgliad-profil-fon-reptiliia.jpg",
//                interestingFact = "Chameleons are native to Africa and Madagascar and are found in a variety of habitats including forests, savannas, and deserts.\n" +
//                        "Chameleons have large, bulging eyes that can move independently, allowing them to see 360 degrees without moving their head.",
//                aboutFauna = "Chameleons or chamaeleons (family Chamaeleonidae) are a distinctive and highly specialized clade of Old World lizards with 200 species described as of June 2015.[1] The members of this family are best known for their distinct range of colors, being capable of shifting to different hues and degrees of brightness. The large number of species in the family exhibit considerable variability in their capacity to change color. For some, it is more of a shift of brightness (shades of brown); for others, a plethora of color-combinations (reds, yellows, greens, blues) can be seen.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//            FaunaDomain(
//                objectId = UUID.randomUUID().toString(),
//                classes = "Reptile",
//                name = "Lizard",
//                backgroundImage = "https://www.wallpaperu3.com/wp-content/mywallpapers/green-lizard-wallpaper-4k-1080x1920.jpg",
//                image = "https://w.forfun.com/fetch/5f/5f3367a812543a462ca3933ccaeac904.jpeg",
//                interestingFact = "Many types of lizards do not need to be close to the water in order to survive since they will often absorb all the water they need from their food.\n" +
//                        "Some lizards can go their entire life without drinking any water at all.\n" +
//                        "That’s one of the reasons why many of them live near the desert, while others live near ponds and other bodies of water.",
//                aboutFauna = "Lizards are a widespread group of squamate reptiles, with over 7,000 species,[1] ranging across all continents except Antarctica, as well as most oceanic island chains. The group is paraphyletic since it excludes the snakes and Amphisbaenia, and some lizards are more closely related to these two excluded groups than they are to other lizards. Lizards range in size from chameleons and geckos a few centimeters long to the 3-meter-long Komodo dragon.",
//                location = "African",
//                updatedAt = "",
//                createdAt = "",
//                locationImage = "",
//            ),
//        )
//        fun fakeFloraDomainAll() = listOf(
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Jade grapes",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/dd3c308e7abc4aeddf6cb452b0edc7c1_back_image_jadegrapes.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/b64f2b1bea4616ce3b9d288f732bf3bc_image_jadegrapes.jpg",
//                interestingFact = "The Chinese love and respect jade stone and precious jadeite - from this material they make precious jewelry and household items, as well as beautiful flower and fruit compositions. Check out these amazing jadeite grape clusters today!\n",
//                aboutFlora = "Jade grapes. Its peculiarity is its flowers of an amazing blue-green hue, shaped like a claw. The stem can grow up to 18 meters in length, and flower clusters - up to 3 meters. The nectar from the flowers is drunk by bats, which pollinate them."
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Cosmos atrosanguineus",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/298cb5d33247c5d9959164fda152539b_back_image_cosmosatrosanguineus.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/aca03be4f44532ac7eaa432aaf7f9eec_image_cosmosatrosanguineus.jpg",
//                interestingFact = "The Cosmos atrosanguineus (Chocolate cosmos) emits a seductive scent of chocolate and with its dark red blossoms, it steals the show from the classic shrubs. Although this floral beauty is not perfectly winterproof, it still has the vitality to be cultivated for several years.\n",
//                aboutFlora = "Cosmos atrosanguineus, the chocolate cosmos, is a species of Cosmos, native to Mexico. It has often been claimed that it is extinct in the wild; however it is \"quite abundant\" in Mexico. The species was introduced into cultivation in 1885, when the British seed company Thompson & Morgan first listed it in their seed catalogue.[4] Its dark red to brownish red flowers have a scent resembling chocolate, which is one reason for its popularity as a cultivated plant.\\"
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Epiphyllum oxypetalum",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/a84eeeecc1e2e9f436f8af683e9464f1_back_image_epiphyllumoxypetalum.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/e22dd33a9a01942e97af0216abab00a2_image_epiphyllumoxypetalum.jpg",
//                interestingFact = "The Epiphyllum oxypetalum, also known as the Queen of the Night, Dutchman’s Pipe, and Wijaya Kusuma, is a parasitic shrub belonging to the cactus family. Known as the “beauty under the moon”, its fleeting blooming period led to the phrase “as fleeting as the Epiphyllum flower”.\n",
//                aboutFlora = "Epiphyllum oxypetalum, the Dutchman's pipe cactus,[3] princess of the night or queen of the night,[4] is a species of cactus. It blooms nocturnally, and its flowers wilt before dawn. Though it is sometimes referred to as a night-blooming cereus, it is not closely related to any of the species in the tribe Cereeae, such as Selenicereus, that are more commonly known as night-blooming cereus. All Cereus species bloom at night and are terrestrial plants; Epiphyllum species are usually epiphytic."
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Cypripedium parviflorum",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/422fa1932caffc4808a91e63dc8d4988_back_image_cypripediumparviflorum.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/88a10112f5ab24ae8dfacc3df68fad13_image_cypripediumparviflorum.jpg",
//                interestingFact = "Cypripedium parviflorum, commonly known as Yellow Lady's Slipper, is found across virtually all of the United States and Canada, from Alaska to Georgia. It is a widely variable species, with four varieties and multiple hybrids, making identification and delimitation difficult. It produces a large flower with a pale to dark yellow (and very rarely white) pouch-like labellum, which sometimes has reddish spots on the interior. Green or yellowish sepals and petals twist outwards in spirals. It produces up to five stem leaves; both the stem and leaves are covered in thin hairs. It grows in dry to mesic forests, woodlands, fens, prairies, and meadows. It produces a natural hybrid with C. candidum, C. × andrewsii, and may hybridize with C. montanum to produce C. × columbianum.\n",
//                aboutFlora = "Cypripedium parviflorum, commonly known as yellow lady's slipper[4] or moccasin flower,[5] is a lady's slipper orchid native to North America.[3] It is widespread, ranging from Alaska south to Arizona and Georgia.[6] It grows in fens, wetlands, shorelines, and damp woodlands."
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Amorphophallus titanum",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/ed7e65a6984d9504e7ca3e854812a27a_back_image_amorphophallustitanica.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/29d57ed38d7297f3810f87ae9a0e13b4_image_amorphophallustitanica.jpg",
//                interestingFact = "You do not imagine things; Amorphophallus titanum actually resembles a big, lumpy penis. The plant’s scientific name derives from the Greek words for “without shape” (amorphos), “penis” (phallos), and “titanium,” respectively (giant).In 1878, while Italian botanist Odoardo Beccari was exploring the rainforests of Sumatra, a vast island off the west coast of Indonesia, he discovered a massive plant called Amorphophallus titanum. He noted that the specimen’s height was about 10 feet and its circumference was about 5 feet.It’s little surprise that the corpse flower became notorious in Europe; an English artist who was commissioned to draw it allegedly fell ill from the stench, and governesses banned their charges from gazing upon the plant.",
//                aboutFlora = "Amorphophallus titanum, the titan arum, is a flowering plant in the family Araceae. It has the largest unbranched inflorescence in the world. The inflorescence of the talipot palm, Corypha umbraculifera, is larger, but it is branched rather than unbranched. A. titanum is endemic to rainforests on the Indonesian island of Sumatra.\n"
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Palicourea elata",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/cb8bcbec7537fcda7fed2a0ccb08f95e_back_image_psychotriaelata.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/bb13fc1355ac6c5445f953a649f0c68f_image_psychotriaelata.jpg",
//                interestingFact = "In as much as you would want to give them as Valentine’s gift, the truth is that it might be difficult for you. They only grow in very delicate weather conditions. They can be found mostly in Central and South American countries like Colombia, Costa Rica, Ecuador and Panama. They all look like kissable lips, but they come in different shapes and forms too.Due to uncontrolled deforestation of their natural habitats, it is now difficult to find one. There are a lot of images available for now, and soon they will just be a part of our memory. There are conservation efforts to increase the number of the plant, but it is quite difficult and expensive. In short, they are just kissable for only a while now, before they are gone.",
//                aboutFlora = "Palicourea elata, formerly Psychotria elata,[1] commonly known as girlfriend kiss[2] and labios de puta,[3] is a tropical plant that ranges from Central to South American rain forests in countries such as Mexico, Costa Rica, Ecuador, Panama, and Colombia.[4] Palicourea elata is extremely sensitive and requires specific climates to grow, those climates most like rainforests are best suitable for this plant. It is most notable for its distinctly shaped red bracts and is consequently nicknamed “Hot Lips”. Though the bright red bracts are considered its most flashy feature, they are not the actual flowers of the plant but instead extravagant leaves; the flowers of Palicourea elata lie within the “red lip” leaves."
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Orchis italica",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/135bc1ba8169ebd0b5e13b837abf2e5d_back_image_orchisitalica.JPG",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/5d1239bbdf3f2011c446a1223202f6bc_image_orchisitalica.jpg",
//                interestingFact = "The Naked Man Orchid grows up to 50cm tall and features a rosette of distinctive wavy-margined leaves at the end of the plant. The fallen leaves are sometimes flecked with brown. There are an extra 3 or 4 tiny leaves encasing the stem. The flowers are brought throughout a thick inflorescence and are typically pale to dark pink.best understood Mediterranean orchids.is Orchis Italica, There are around 800 category of orchids. The orchis (Orchis Italica) most remarkable category of the orchid family\n",
//                aboutFlora = "Orchis italica, the naked man orchid or the Italian orchid, is a species of orchid native to the Mediterranean Basin.[2] It gets its common name from the lobed lip (labellum) of each flower which mimics the general shape of a naked man. In Italy, it is believed that the consumption of the plant is conducive to virility.[3] It prefers partial shade and low nutrient soil, and flowers in April. Orchis italica grows up to 50 centimetres (20 in) in height, with bright pink, densely clustered flowers."
//            ),
//            FloraDomain(
//                id = UUID.randomUUID().toString(),
//                name = "Phalaenopsis",
//                backgroundImage = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/0ef6afe256132e520f513be25c5981c1_back_image_phalaenopsis.jpg",
//                image = "https://parsefiles.back4app.com/9vPgjmBh1bjCl0HXwjbWb6xJPtb59ad6eV6kKV5x/79da305e3aebd8cd93b68f429b8a359e_image_phalaenopsis.jpg",
//                interestingFact = "You may have heard Phalaenopsis orchids called “moth orchids” before. While it might seem like the nickname originated from the appearance of the blooms — which do look like a pretty moth taking flight — the actual reason for the nickname goes much deeper. “Phalaenopsis” comes from the Latin word “phal,” which translates to “moth.” Of course, this isn’t a coincidence: Carl Ludwig Blume, who gave Phalaenopsis orchids their name, supposedly chose it due to the moth resemblance.If you’ve ever woken up in the morning to the sweet smell of orchids and wondered why your nose was so keen to the scent in the early morning, it turns out there’s actually a reason for that. The lightly sweet smell of a flowering orchid is actually most pronounced at sunrise.",
//                aboutFlora = "You may have heard Phalaenopsis orchids called “moth orchids” before. While it might seem like the nickname originated from the appearance of the blooms — which do look like a pretty moth taking flight — the actual reason for the nickname goes much deeper. “Phalaenopsis” comes from the Latin word “phal,” which translates to “moth.” Of course, this isn’t a coincidence: Carl Ludwig Blume, who gave Phalaenopsis orchids their name, supposedly chose it due to the moth resemblance.If you’ve ever woken up in the morning to the sweet smell of orchids and wondered why your nose was so keen to the scent in the early morning, it turns out there’s actually a reason for that. The lightly sweet smell of a flowering orchid is actually most pronounced at sunrise."
//            ),
//        )
//
//    }
//}