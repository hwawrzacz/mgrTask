PGDMP     %                    w           mgrTask    11.5    11.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16393    mgrTask    DATABASE     �   CREATE DATABASE "mgrTask" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Polish_Poland.1250' LC_CTYPE = 'Polish_Poland.1250';
    DROP DATABASE "mgrTask";
             postgres    false            �            1259    16527    groups    TABLE     X   CREATE TABLE public.groups (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.groups;
       public         postgres    false            �            1259    16415    hibernate_sequence    SEQUENCE     �   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    CYCLE;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false            �            1259    16532    students    TABLE     o   CREATE TABLE public.students (
    id bigint NOT NULL,
    name character varying(255),
    group_id bigint
);
    DROP TABLE public.students;
       public         postgres    false            �            1259    16542    tasks    TABLE       CREATE TABLE public.tasks (
    id bigint NOT NULL,
    category character varying(255),
    creation_date date,
    description character varying(255),
    expiration_date date,
    name character varying(255),
    author_id bigint,
    receiver_id bigint
);
    DROP TABLE public.tasks;
       public         postgres    false            �            1259    16550    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    login character varying(255),
    password character varying(255)
);
    DROP TABLE public.users;
       public         postgres    false                      0    16527    groups 
   TABLE DATA               *   COPY public.groups (id, name) FROM stdin;
    public       postgres    false    197   �                 0    16532    students 
   TABLE DATA               6   COPY public.students (id, name, group_id) FROM stdin;
    public       postgres    false    198   �                 0    16542    tasks 
   TABLE DATA               x   COPY public.tasks (id, category, creation_date, description, expiration_date, name, author_id, receiver_id) FROM stdin;
    public       postgres    false    199   [                 0    16550    users 
   TABLE DATA               K   COPY public.users (id, first_name, last_name, login, password) FROM stdin;
    public       postgres    false    200   �                  0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 70, true);
            public       postgres    false    196            �
           2606    16531    groups groups_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.groups DROP CONSTRAINT groups_pkey;
       public         postgres    false    197            �
           2606    16536    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public         postgres    false    198            �
           2606    16549    tasks tasks_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_pkey;
       public         postgres    false    199            �
           2606    16559 "   users uk_ow0gan20590jrb00upg3va2fn 
   CONSTRAINT     ^   ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_ow0gan20590jrb00upg3va2fn UNIQUE (login);
 L   ALTER TABLE ONLY public.users DROP CONSTRAINT uk_ow0gan20590jrb00upg3va2fn;
       public         postgres    false    200            �
           2606    16557    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    200            �
           2606    16560 !   tasks fkhods8r8oyyx7tuj3c91ki2sk1    FK CONSTRAINT     �   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkhods8r8oyyx7tuj3c91ki2sk1 FOREIGN KEY (author_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.tasks DROP CONSTRAINT fkhods8r8oyyx7tuj3c91ki2sk1;
       public       postgres    false    199    2708    200            �
           2606    16537 $   students fkmsev1nou0j86spuk5jrv19mss    FK CONSTRAINT     �   ALTER TABLE ONLY public.students
    ADD CONSTRAINT fkmsev1nou0j86spuk5jrv19mss FOREIGN KEY (group_id) REFERENCES public.groups(id);
 N   ALTER TABLE ONLY public.students DROP CONSTRAINT fkmsev1nou0j86spuk5jrv19mss;
       public       postgres    false    197    2700    198            �
           2606    16565 !   tasks fkod4nsd69oox6xvdej27il8gmn    FK CONSTRAINT     �   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fkod4nsd69oox6xvdej27il8gmn FOREIGN KEY (receiver_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.tasks DROP CONSTRAINT fkod4nsd69oox6xvdej27il8gmn;
       public       postgres    false    199    200    2708               )   x�35�t/�/-P0�25�2��L͠Lc.Ss(ӄ+F��� >L         M   x�3���(MJ-*QO,/�JL����2��&jj�U���1VQ��X�`��fX�`��fFXE��� Ss�=... �2\         �   x�33�,,,O�4�47�50"��Ϙ�#5#��̄�̔�̂�)3��#�ɩ�&�&� %F&��Gw)������P�������]��X����, Uj�%��47@2����P����id``Vf���=... m�Z]         T   x�33��(MJ-*�O,/�JL���(M*O,�,,�Vs��r:�$�rz�'�ggr&�$f磨0��J�C(�J�CU���� ��"�     