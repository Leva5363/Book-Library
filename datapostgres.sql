--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-06-18 20:37:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 208 (class 1259 OID 19050)
-- Name: author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.author (
    id integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.author OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 19048)
-- Name: author_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.author_id_seq OWNER TO postgres;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 207
-- Name: author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;


--
-- TOC entry 204 (class 1259 OID 19026)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id integer NOT NULL,
    id_author integer NOT NULL,
    name text NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 19024)
-- Name: book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_id_seq OWNER TO postgres;

--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 203
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;


--
-- TOC entry 206 (class 1259 OID 19037)
-- Name: library; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.library (
    id integer NOT NULL,
    id_book integer NOT NULL,
    amount_book integer NOT NULL
);


ALTER TABLE public.library OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 19035)
-- Name: library_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.library_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.library_id_seq OWNER TO postgres;

--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 205
-- Name: library_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.library_id_seq OWNED BY public.library.id;


--
-- TOC entry 210 (class 1259 OID 19061)
-- Name: reader; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reader (
    id integer NOT NULL,
    name text NOT NULL,
    lastname text NOT NULL
);


ALTER TABLE public.reader OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 19059)
-- Name: reader_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reader_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reader_id_seq OWNER TO postgres;

--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 209
-- Name: reader_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reader_id_seq OWNED BY public.reader.id;


--
-- TOC entry 212 (class 1259 OID 19072)
-- Name: record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.record (
    id integer NOT NULL,
    id_reader integer NOT NULL,
    id_book integer NOT NULL,
    date_take date NOT NULL,
    date_return date
);


ALTER TABLE public.record OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 19070)
-- Name: record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.record_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.record_id_seq OWNER TO postgres;

--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 211
-- Name: record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.record_id_seq OWNED BY public.record.id;


--
-- TOC entry 2717 (class 2604 OID 19053)
-- Name: author id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 19029)
-- Name: book id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 19040)
-- Name: library id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.library ALTER COLUMN id SET DEFAULT nextval('public.library_id_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 19064)
-- Name: reader id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reader ALTER COLUMN id SET DEFAULT nextval('public.reader_id_seq'::regclass);


--
-- TOC entry 2719 (class 2604 OID 19075)
-- Name: record id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record ALTER COLUMN id SET DEFAULT nextval('public.record_id_seq'::regclass);


--
-- TOC entry 2865 (class 0 OID 19050)
-- Dependencies: 208
-- Data for Name: author; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.author (id, name) FROM stdin;
1	Pushkin
2	Gogol
3	Shakespeare
4	Lermontov
5	Bulgakov
6	Tolstoi
7	Miagkov
8	Turgeniev
9	Lavrov
10	Chehov
\.


--
-- TOC entry 2861 (class 0 OID 19026)
-- Dependencies: 204
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (id, id_author, name) FROM stdin;
1	10	Palata 6
2	9	Holodnaya osen
3	8	Fathers and sons
4	7	Sivi merin
5	6	War and peace
6	5	The master and Margarita
7	4	A hero of our
8	3	Romeo and Juliet
9	2	Dead souls
10	1	Captain"s daughter
11	2	The master a
\.


--
-- TOC entry 2863 (class 0 OID 19037)
-- Dependencies: 206
-- Data for Name: library; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.library (id, id_book, amount_book) FROM stdin;
1	1	10
2	2	20
3	3	30
4	4	40
5	5	50
6	6	60
7	7	70
8	8	80
9	9	90
10	10	100
30	11	122
\.


--
-- TOC entry 2867 (class 0 OID 19061)
-- Dependencies: 210
-- Data for Name: reader; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reader (id, name, lastname) FROM stdin;
1	Roman	Lev
2	Katya	Lev
3	Sergri	Edinburg
4	Natalia	Edinburg
5	Sergei	Gutovski
6	Sofia	Kogan
7	Iliya	Bondaronok
8	Valentina	Juk
9	Alexandr	Rozembaum
10	Daniel	Voltin
\.


--
-- TOC entry 2869 (class 0 OID 19072)
-- Dependencies: 212
-- Data for Name: record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.record (id, id_reader, id_book, date_take, date_return) FROM stdin;
3	3	2	2020-02-25	2020-04-11
4	4	10	2020-01-15	2020-02-23
5	5	4	2020-02-01	2020-03-20
7	10	1	2020-01-11	2020-02-21
8	7	7	2020-02-01	2020-02-28
9	8	6	2000-01-01	2020-01-01
10	9	3	2019-05-08	2020-01-01
12	5	5	2020-01-01	\N
14	10	2	2020-01-01	\N
25	1	10	2020-01-01	\N
26	1	9	2018-01-01	\N
2	2	8	2020-02-12	2020-05-12
\.


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 207
-- Name: author_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.author_id_seq', 10, true);


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 203
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_id_seq', 11, true);


--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 205
-- Name: library_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.library_id_seq', 30, true);


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 209
-- Name: reader_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reader_id_seq', 10, true);


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 211
-- Name: record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.record_id_seq', 27, true);


--
-- TOC entry 2725 (class 2606 OID 19058)
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);


--
-- TOC entry 2721 (class 2606 OID 19034)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 19042)
-- Name: library library_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_pkey PRIMARY KEY (id);


--
-- TOC entry 2727 (class 2606 OID 19069)
-- Name: reader reader_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reader
    ADD CONSTRAINT reader_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 19077)
-- Name: record record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record
    ADD CONSTRAINT record_pkey PRIMARY KEY (id);


--
-- TOC entry 2730 (class 2606 OID 19088)
-- Name: book book_id_author_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_id_author_fkey FOREIGN KEY (id_author) REFERENCES public.author(id);


--
-- TOC entry 2731 (class 2606 OID 19043)
-- Name: library library_id_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.library
    ADD CONSTRAINT library_id_book_fkey FOREIGN KEY (id_book) REFERENCES public.book(id);


--
-- TOC entry 2733 (class 2606 OID 19083)
-- Name: record record_id_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record
    ADD CONSTRAINT record_id_book_fkey FOREIGN KEY (id_book) REFERENCES public.book(id);


--
-- TOC entry 2732 (class 2606 OID 19078)
-- Name: record record_id_reader_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.record
    ADD CONSTRAINT record_id_reader_fkey FOREIGN KEY (id_reader) REFERENCES public.reader(id);


-- Completed on 2020-06-18 20:37:01

--
-- PostgreSQL database dump complete
--

