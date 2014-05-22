--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: NewPlan; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE "NewPlan" IS 'Smile';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: course_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE course_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.course_id OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE courses (
    "idCourse" integer DEFAULT nextval('course_id'::regclass) NOT NULL,
    "NameCourse" text NOT NULL
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- Name: TABLE courses; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE courses IS 'Курсы';


--
-- Name: COLUMN courses."idCourse"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN courses."idCourse" IS 'dasd';


--
-- Name: COLUMN courses."NameCourse"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN courses."NameCourse" IS 'adsdfuohvSDgh[';


--
-- Name: dnamedic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dnamedic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.dnamedic_id OWNER TO postgres;

--
-- Name: dnamedic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dnamedic (
    code integer DEFAULT nextval('dnamedic_id'::regclass) NOT NULL,
    name text,
    okr integer
);


ALTER TABLE public.dnamedic OWNER TO postgres;

--
-- Name: dsubtypedic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dsubtypedic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.dsubtypedic_id OWNER TO postgres;

--
-- Name: dsubtypedic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dsubtypedic (
    code integer DEFAULT nextval('dsubtypedic_id'::regclass) NOT NULL,
    name text,
    dtype integer
);


ALTER TABLE public.dsubtypedic OWNER TO postgres;

--
-- Name: gzdic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE gzdic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.gzdic_id OWNER TO postgres;

--
-- Name: gzdic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE gzdic (
    code integer DEFAULT nextval('gzdic_id'::regclass) NOT NULL,
    name text,
    id text NOT NULL
);


ALTER TABLE public.gzdic OWNER TO postgres;

--
-- Name: legendic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE legendic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.legendic_id OWNER TO postgres;

--
-- Name: legendic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE legendic (
    code integer DEFAULT nextval('legendic_id'::regclass),
    name text,
    note text
);


ALTER TABLE public.legendic OWNER TO postgres;

--
-- Name: COLUMN legendic.code; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN legendic.code IS 'fsdf';


--
-- Name: npdic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE npdic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.npdic_id OWNER TO postgres;

--
-- Name: npdic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE npdic (
    code integer DEFAULT nextval('npdic_id'::regclass) NOT NULL,
    name text,
    id text NOT NULL,
    gz integer NOT NULL,
    ft integer NOT NULL
);


ALTER TABLE public.npdic OWNER TO postgres;

--
-- Name: okrdic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE okrdic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.okrdic_id OWNER TO postgres;

--
-- Name: okrdic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE okrdic (
    code integer DEFAULT nextval('okrdic_id'::regclass) NOT NULL,
    name text,
    id text NOT NULL
);


ALTER TABLE public.okrdic OWNER TO postgres;

--
-- Name: plan_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE plan_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.plan_id OWNER TO postgres;

--
-- Name: plan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan (
    idplan integer DEFAULT nextval('plan_id'::regclass) NOT NULL,
    date timestamp with time zone,
    text text
);


ALTER TABLE public.plan OWNER TO postgres;

--
-- Name: values_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE values_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.values_id OWNER TO postgres;

--
-- Name: planvalues; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE planvalues (
    id integer DEFAULT nextval('values_id'::regclass) NOT NULL,
    course integer,
    week integer,
    value text,
    idplan integer
);


ALTER TABLE public.planvalues OWNER TO postgres;

--
-- Name: spdic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE spdic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.spdic_id OWNER TO postgres;

--
-- Name: spdic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE spdic (
    code integer DEFAULT nextval('spdic_id'::regclass) NOT NULL,
    name text,
    id text NOT NULL,
    gz integer NOT NULL,
    okr integer NOT NULL,
    ft integer NOT NULL
);


ALTER TABLE public.spdic OWNER TO postgres;

--
-- Name: subspdic_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE subspdic_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000
    CACHE 1;


ALTER TABLE public.subspdic_id OWNER TO postgres;

--
-- Name: subspdic; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE subspdic (
    code integer DEFAULT nextval('subspdic_id'::regclass) NOT NULL,
    name text,
    sp integer NOT NULL
);


ALTER TABLE public.subspdic OWNER TO postgres;

--
-- Name: course_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('course_id', 1, false);


--
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: dnamedic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO dnamedic VALUES (1, 'Іноземна мова', 2);
INSERT INTO dnamedic VALUES (2, 'Історія філософії', 2);
INSERT INTO dnamedic VALUES (3, 'Історія України', 2);
INSERT INTO dnamedic VALUES (4, 'Українська мова (за професійним спрямуванням)', 2);
INSERT INTO dnamedic VALUES (5, 'Історія філософської думки України', 2);
INSERT INTO dnamedic VALUES (7, 'Психологія', 2);
INSERT INTO dnamedic VALUES (8, 'Філософія', 2);
INSERT INTO dnamedic VALUES (9, 'Політологія', 2);
INSERT INTO dnamedic VALUES (11, 'Соціологія', 2);
INSERT INTO dnamedic VALUES (12, 'Фізичне виховання', 2);
INSERT INTO dnamedic VALUES (18, 'Екологія', 2);
INSERT INTO dnamedic VALUES (50, 'Вступ до спеціальності та інформаційна культура студента', 2);
INSERT INTO dnamedic VALUES (57, 'Адміністративне право', 2);
INSERT INTO dnamedic VALUES (60, 'Історія української культури', 2);
INSERT INTO dnamedic VALUES (62, 'Безпека життєдіяльності', 2);
INSERT INTO dnamedic VALUES (63, 'Основи охорони праці', 2);
INSERT INTO dnamedic VALUES (73, 'Інформатика', 2);
INSERT INTO dnamedic VALUES (75, 'Основи економічної теорії', 2);
INSERT INTO dnamedic VALUES (76, 'Етика та естетика', 2);
INSERT INTO dnamedic VALUES (77, 'Риторика', 2);
INSERT INTO dnamedic VALUES (78, 'Політичне прогнозування', 2);
INSERT INTO dnamedic VALUES (79, 'Соціальне прогнозування', 2);
INSERT INTO dnamedic VALUES (80, 'Компаративістика', 2);
INSERT INTO dnamedic VALUES (81, 'Глобалістика', 2);
INSERT INTO dnamedic VALUES (82, 'Політична реклама', 2);
INSERT INTO dnamedic VALUES (83, 'Інформаційна політика', 2);
INSERT INTO dnamedic VALUES (84, 'Гендерні дослідження', 2);
INSERT INTO dnamedic VALUES (85, 'Міжнародна та європейська безпека України', 2);
INSERT INTO dnamedic VALUES (86, 'Археологія', 2);
INSERT INTO dnamedic VALUES (87, 'Спеціальні історичні дисципліни', 2);
INSERT INTO dnamedic VALUES (88, 'Загальна етнологія', 2);
INSERT INTO dnamedic VALUES (89, 'Етнологія України', 2);
INSERT INTO dnamedic VALUES (90, 'Латинська мова', 2);
INSERT INTO dnamedic VALUES (91, 'Старослов''янська мова', 2);
INSERT INTO dnamedic VALUES (92, 'Історія історичної науки', 2);
INSERT INTO dnamedic VALUES (93, 'Теорія та методика навчання історії', 2);
INSERT INTO dnamedic VALUES (94, 'Методи історичних досліджень', 2);
INSERT INTO dnamedic VALUES (95, 'Психологія', 2);
INSERT INTO dnamedic VALUES (96, 'Педагогіка', 2);
INSERT INTO dnamedic VALUES (97, 'Логіка', 2);
INSERT INTO dnamedic VALUES (98, 'Основи права України', 2);
INSERT INTO dnamedic VALUES (99, 'Історія Середніх віків та раннього нового часу', 2);
INSERT INTO dnamedic VALUES (100, 'Нова та новітня історія Західної Європи та Північної Америки', 2);
INSERT INTO dnamedic VALUES (101, 'Історія України', 2);
INSERT INTO dnamedic VALUES (102, 'Історія первісного суспільства', 2);
INSERT INTO dnamedic VALUES (103, 'Історія Стародавнього Сходу', 2);
INSERT INTO dnamedic VALUES (104, 'Історія Стародавньої Греції та Риму', 2);
INSERT INTO dnamedic VALUES (105, 'Історія країн Центральної та Південно-Східної Європи', 2);
INSERT INTO dnamedic VALUES (106, 'Історія Росії/СРСР', 2);
INSERT INTO dnamedic VALUES (107, 'Історія країн Сходу', 2);
INSERT INTO dnamedic VALUES (108, 'Основи права України', 2);
INSERT INTO dnamedic VALUES (109, 'Курсова робота', 2);
INSERT INTO dnamedic VALUES (110, 'Кваліфікаційна робота бакалавра', 2);
INSERT INTO dnamedic VALUES (111, 'Комплексний державний екзамен зі спеціальності', 2);
INSERT INTO dnamedic VALUES (112, 'Виробнича педагогічна практика', 2);
INSERT INTO dnamedic VALUES (113, 'Джерелознавство', 2);
INSERT INTO dnamedic VALUES (114, 'Архівознавство', 2);
INSERT INTO dnamedic VALUES (115, 'Музеєзнавство', 2);
INSERT INTO dnamedic VALUES (116, 'Історія зарубіжної та української культури', 2);
INSERT INTO dnamedic VALUES (117, 'Мова спеціальності', 2);
INSERT INTO dnamedic VALUES (118, 'Історичне краєзнавство', 2);
INSERT INTO dnamedic VALUES (119, 'Історія державних установ України', 2);
INSERT INTO dnamedic VALUES (120, 'Історія релігій', 2);
INSERT INTO dnamedic VALUES (121, 'Основи діловодства', 2);
INSERT INTO dnamedic VALUES (122, 'Археографія', 2);
INSERT INTO dnamedic VALUES (123, 'Історична географія', 2);
INSERT INTO dnamedic VALUES (124, 'Документознавство', 2);
INSERT INTO dnamedic VALUES (125, 'Українська історіографія', 2);
INSERT INTO dnamedic VALUES (126, 'Історія міжнародних відносин', 2);
INSERT INTO dnamedic VALUES (127, 'Комп''ютерна техніка в архівній справі', 2);
INSERT INTO dnamedic VALUES (128, 'Основи методики наукового пошуку', 2);
INSERT INTO dnamedic VALUES (129, 'Організація охорони пам''яток історії', 2);
INSERT INTO dnamedic VALUES (130, 'Історія освіти і науки України', 2);
INSERT INTO dnamedic VALUES (131, 'Комп''ютерна обробка текстів з історії', 2);
INSERT INTO dnamedic VALUES (132, 'Історія українського козацтва', 2);
INSERT INTO dnamedic VALUES (133, 'Джерела з історії України', 2);
INSERT INTO dnamedic VALUES (134, 'Історія українського мистецтва', 2);
INSERT INTO dnamedic VALUES (135, 'Етапи державотворення України', 2);
INSERT INTO dnamedic VALUES (136, 'Комп''ютерна графіка для істориків', 2);
INSERT INTO dnamedic VALUES (137, 'Південноукраїнський регіон у контексті формування модерної нації (ХІХ - перша чверть ХХ ст.)', 2);
INSERT INTO dnamedic VALUES (138, 'Історія ментальностей України', 2);
INSERT INTO dnamedic VALUES (139, 'Етноконфесіні відносини в Україні', 2);
INSERT INTO dnamedic VALUES (140, 'Українська археографія ХІХ - початку ХХ ст.', 2);
INSERT INTO dnamedic VALUES (141, 'Історична географія Південної України', 2);
INSERT INTO dnamedic VALUES (142, 'Історія Олександрівської фортеці (1770-1785 рр.)', 2);
INSERT INTO dnamedic VALUES (143, 'Теорія і практика усної історії', 2);
INSERT INTO dnamedic VALUES (144, 'Запорізьке козацтво періоду Нової Січі', 2);
INSERT INTO dnamedic VALUES (145, 'Літописознавство', 2);
INSERT INTO dnamedic VALUES (146, 'Побут населення Південної України', 2);
INSERT INTO dnamedic VALUES (147, 'Методи джерелознавчого аналізу', 2);
INSERT INTO dnamedic VALUES (148, 'Трудове право', 2);
INSERT INTO dnamedic VALUES (149, 'Відомчі архіви', 2);
INSERT INTO dnamedic VALUES (150, 'Сучасна організація державної служби в Україні', 2);
INSERT INTO dnamedic VALUES (151, 'Основи статистики', 2);
INSERT INTO dnamedic VALUES (152, 'Ділове спілкування', 2);
INSERT INTO dnamedic VALUES (153, 'Державні установи України', 2);
INSERT INTO dnamedic VALUES (154, 'Захист інформації', 2);
INSERT INTO dnamedic VALUES (155, 'Екологічне право', 2);
INSERT INTO dnamedic VALUES (156, 'Історія вчень про дераву і право', 2);
INSERT INTO dnamedic VALUES (157, 'Історія дерави і права зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (158, 'Історія держави і права України', 2);
INSERT INTO dnamedic VALUES (159, 'Конституційне право зарубіних країн', 2);
INSERT INTO dnamedic VALUES (160, 'Конституційне право України', 2);
INSERT INTO dnamedic VALUES (161, 'Криміналістика', 2);
INSERT INTO dnamedic VALUES (162, 'Кримінальне право', 2);
INSERT INTO dnamedic VALUES (163, 'Кримінальний процес', 2);
INSERT INTO dnamedic VALUES (164, 'Логіка', 2);
INSERT INTO dnamedic VALUES (165, 'Міжнародне право', 2);
INSERT INTO dnamedic VALUES (166, 'Судові та правоохоронні органи', 2);
INSERT INTO dnamedic VALUES (167, 'Теорія держави та права', 2);
INSERT INTO dnamedic VALUES (168, 'Трудове право', 2);
INSERT INTO dnamedic VALUES (169, 'Фінансове право', 2);
INSERT INTO dnamedic VALUES (170, 'Цивільне та сімейне право', 2);
INSERT INTO dnamedic VALUES (171, 'Цивільний процес', 2);
INSERT INTO dnamedic VALUES (172, 'Юридична деонтологія', 2);
INSERT INTO dnamedic VALUES (173, 'Аграрне право', 2);
INSERT INTO dnamedic VALUES (174, 'Адвокатура України', 2);
INSERT INTO dnamedic VALUES (175, 'Адміністративна відповідальність', 2);
INSERT INTO dnamedic VALUES (176, 'Господарський процес', 2);
INSERT INTO dnamedic VALUES (177, 'Житлове право', 2);
INSERT INTO dnamedic VALUES (178, 'Кримінально-виконавче право', 2);
INSERT INTO dnamedic VALUES (179, 'Кримінологія', 2);
INSERT INTO dnamedic VALUES (180, 'Латинська мова', 2);
INSERT INTO dnamedic VALUES (181, 'Міжнародне приватне право', 2);
INSERT INTO dnamedic VALUES (182, 'Муніципальне право', 2);
INSERT INTO dnamedic VALUES (183, 'Нотаріат України', 2);
INSERT INTO dnamedic VALUES (184, 'Основи римського цивільного права', 2);
INSERT INTO dnamedic VALUES (185, 'Правова статистика', 2);
INSERT INTO dnamedic VALUES (186, 'Правові основи підприємницької діяльності', 2);
INSERT INTO dnamedic VALUES (187, 'Судова бухгалтерія', 2);
INSERT INTO dnamedic VALUES (188, 'Судова медицина та психіатрія', 2);
INSERT INTO dnamedic VALUES (189, 'Адміністративне судочинство', 2);
INSERT INTO dnamedic VALUES (190, 'Банківське право', 2);
INSERT INTO dnamedic VALUES (191, 'Господарське право', 2);
INSERT INTO dnamedic VALUES (192, 'Документація в цивільному процесі', 2);
INSERT INTO dnamedic VALUES (193, 'Земельне право', 2);
INSERT INTO dnamedic VALUES (194, 'Інформаційні ресурси в юриспруденції', 2);
INSERT INTO dnamedic VALUES (195, 'Конституційні права, свободи та обов''язки людини та громадянина в Україні', 2);
INSERT INTO dnamedic VALUES (196, 'Кримінальне право зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (197, 'Кримінально-процесуальні документи', 2);
INSERT INTO dnamedic VALUES (198, 'Менеджмент та маркетинг', 2);
INSERT INTO dnamedic VALUES (200, 'Право соціального захисту', 2);
INSERT INTO dnamedic VALUES (201, 'Трудові спори', 2);
INSERT INTO dnamedic VALUES (202, 'Порівняльне правознавство', 2);
INSERT INTO dnamedic VALUES (203, 'Навчальна практика в судових та правоохоронних органах', 2);
INSERT INTO dnamedic VALUES (204, 'Навчальна практика в органах державної влади та державних установах', 2);
INSERT INTO dnamedic VALUES (205, 'Виробнича практика в органах державної влади та державних установах', 2);
INSERT INTO dnamedic VALUES (206, 'Етика та естетика', 2);
INSERT INTO dnamedic VALUES (207, 'Інформаційна політика', 2);
INSERT INTO dnamedic VALUES (208, 'Культурологія', 2);
INSERT INTO dnamedic VALUES (209, 'Міжнародна та європейська безпека України', 2);
INSERT INTO dnamedic VALUES (210, 'Психологія', 2);
INSERT INTO dnamedic VALUES (214, 'Гендерний дискурс в історії України', 2);
INSERT INTO dnamedic VALUES (215, 'Суспільно-політичний рух в Україні (друга половина ХІХ - початок ХХІ ст.)', 2);
INSERT INTO dnamedic VALUES (216, 'Політична арена України: дійові особи та виконавці', 2);
INSERT INTO dnamedic VALUES (217, 'Інтернет для істориків', 2);
INSERT INTO dnamedic VALUES (218, 'Історіографія історії Украни', 2);
INSERT INTO dnamedic VALUES (219, 'Мемуарна література з історії України ХVІІІ-ХХ ст.', 2);
INSERT INTO dnamedic VALUES (220, 'Державні установи Південної України ХVІІІ - початку ХХ ст.', 2);
INSERT INTO dnamedic VALUES (221, 'Губернські архівні комісії', 2);
INSERT INTO dnamedic VALUES (222, 'Персонологія історії Південної України', 2);
INSERT INTO dnamedic VALUES (223, 'Вітчизняна епістологія', 2);
INSERT INTO dnamedic VALUES (224, 'Соціальна історія запорізького козацтва', 2);
INSERT INTO dnamedic VALUES (225, 'Дворянство Південної України', 2);
INSERT INTO dnamedic VALUES (226, 'Історія Південної України', 2);
INSERT INTO dnamedic VALUES (227, 'Системи електронного документування', 2);
INSERT INTO dnamedic VALUES (228, 'Уніфіковані системи документації', 2);
INSERT INTO dnamedic VALUES (229, 'Менеджмент', 2);
INSERT INTO dnamedic VALUES (230, 'Інформаційне забезпечення управління', 2);
INSERT INTO dnamedic VALUES (231, 'Матеріально-технічне забезпечення зберігання документації', 2);
INSERT INTO dnamedic VALUES (232, 'Основи інформатики та обчислювальної техніки', 2);
INSERT INTO dnamedic VALUES (233, 'Особливості розслідування комп''ютерних злочинів', 2);
INSERT INTO dnamedic VALUES (234, 'Патентна та ліцензійна документація', 2);
INSERT INTO dnamedic VALUES (235, 'Теоретичні засади експертизи цінності доументів', 2);
INSERT INTO dnamedic VALUES (236, 'Організація служби документаційного забезпечення управління', 2);
INSERT INTO dnamedic VALUES (393, 'Лексикологія', 2);
INSERT INTO dnamedic VALUES (237, 'Проблеми історії Південно-Східної Європи та Північного Причорномор''я в античну добу', 2);
INSERT INTO dnamedic VALUES (238, 'Історія культури Європи', 2);
INSERT INTO dnamedic VALUES (239, 'Проблеми історії Центральної Америки до європейської колонізації', 2);
INSERT INTO dnamedic VALUES (240, 'Інформаційні технології в історичних дослідженнях', 2);
INSERT INTO dnamedic VALUES (241, 'Біотехнія', 2);
INSERT INTO dnamedic VALUES (242, 'Історія культури Сходу', 2);
INSERT INTO dnamedic VALUES (243, 'Історична психологія', 2);
INSERT INTO dnamedic VALUES (244, 'Етнодемографічна історія Європи', 2);
INSERT INTO dnamedic VALUES (245, 'Історичні портрети політичних діячів зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (246, 'Основи пошуку наукової інформації засобами Інтернет', 2);
INSERT INTO dnamedic VALUES (247, 'Політичні системи зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (248, 'Історія міжнародних відносин і дипломатії', 2);
INSERT INTO dnamedic VALUES (249, 'Історичні портрети політичних та державних діячів зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (250, 'Політичні портрети лідерів Сходу', 2);
INSERT INTO dnamedic VALUES (251, 'Політична психологія', 2);
INSERT INTO dnamedic VALUES (252, 'Проблеми міжнародних відносин в добу глобалізації', 2);
INSERT INTO dnamedic VALUES (253, 'Математичні методи в історичних дослідженнях', 2);
INSERT INTO dnamedic VALUES (254, 'Геополітичні та геоекономічні інтереси у світовій політиці', 2);
INSERT INTO dnamedic VALUES (255, 'Економіка та зовнішньоекономічні зв''язки України', 2);
INSERT INTO dnamedic VALUES (256, 'Економічна географія країн світу', 2);
INSERT INTO dnamedic VALUES (257, 'Управління якістю', 2);
INSERT INTO dnamedic VALUES (258, 'Історія української літератури', 2);
INSERT INTO dnamedic VALUES (259, 'Інтелектуальна власність', 3);
INSERT INTO dnamedic VALUES (260, 'Охорона праці в галузі', 3);
INSERT INTO dnamedic VALUES (261, 'Цивільний захист', 3);
INSERT INTO dnamedic VALUES (262, 'Інформаційне право', 3);
INSERT INTO dnamedic VALUES (263, 'Митне право', 3);
INSERT INTO dnamedic VALUES (264, 'Особливості розгляду окремих категорій цивільних справ', 3);
INSERT INTO dnamedic VALUES (265, 'Податкове право', 3);
INSERT INTO dnamedic VALUES (266, 'Правові основи зовнішньоекономічної діяльності', 3);
INSERT INTO dnamedic VALUES (267, 'Прокуратура України', 3);
INSERT INTO dnamedic VALUES (268, 'Теоретичні основи кваліфікації злочинів', 3);
INSERT INTO dnamedic VALUES (269, 'Філософія права', 3);
INSERT INTO dnamedic VALUES (270, 'Цивільне та торговельне право зарубіжних країн', 3);
INSERT INTO dnamedic VALUES (271, 'Економічна історія світу', 2);
INSERT INTO dnamedic VALUES (272, 'Інформаційно-аналітична діяльність в міжнародних відносинах', 2);
INSERT INTO dnamedic VALUES (273, 'Конфліктологія та теорія переговорів', 2);
INSERT INTO dnamedic VALUES (274, 'Менеджмент та маркетинг', 2);
INSERT INTO dnamedic VALUES (275, 'Міжнародна інформація', 2);
INSERT INTO dnamedic VALUES (276, 'Міжнародне приватне право', 2);
INSERT INTO dnamedic VALUES (277, 'Міжнародне публічне право', 2);
INSERT INTO dnamedic VALUES (278, 'Міжнародні економічні відносини', 2);
INSERT INTO dnamedic VALUES (279, 'Основи наукових досліджень', 2);
INSERT INTO dnamedic VALUES (280, 'Політична історія світу', 2);
INSERT INTO dnamedic VALUES (281, 'Порівняльне конституційне право', 2);
INSERT INTO dnamedic VALUES (282, 'Світова економіка', 2);
INSERT INTO dnamedic VALUES (283, 'Сучасні інформаційні системи і технології', 2);
INSERT INTO dnamedic VALUES (284, 'Фізична географія країн світу', 2);
INSERT INTO dnamedic VALUES (285, 'Маркетинг і РR у туристичній діяльності', 2);
INSERT INTO dnamedic VALUES (286, 'Англійська мова', 2);
INSERT INTO dnamedic VALUES (287, 'Гуманістичний чинник у світовій політиці', 2);
INSERT INTO dnamedic VALUES (288, 'Державне управління в Україні', 2);
INSERT INTO dnamedic VALUES (289, 'Дипломатична та консульська служба', 2);
INSERT INTO dnamedic VALUES (290, 'Дипломатичний протокол та етикет', 2);
INSERT INTO dnamedic VALUES (291, 'Друга іноземна мова', 2);
INSERT INTO dnamedic VALUES (292, 'Зовнішня політика України', 2);
INSERT INTO dnamedic VALUES (293, 'Іноземна мова спеціальності', 2);
INSERT INTO dnamedic VALUES (294, 'Країнознавство', 2);
INSERT INTO dnamedic VALUES (295, 'Методологія країнознавчих досліджень', 2);
INSERT INTO dnamedic VALUES (296, 'Оглядові лекції', 2);
INSERT INTO dnamedic VALUES (297, 'Актуальні проблеми економіки та економічної інтеграції країн регіону', 2);
INSERT INTO dnamedic VALUES (298, 'Внутрішньополітичний розвиток країн світу', 2);
INSERT INTO dnamedic VALUES (299, 'Документознавство', 2);
INSERT INTO dnamedic VALUES (300, 'Історія політичних вчень', 2);
INSERT INTO dnamedic VALUES (301, 'Культура, мистецтво та ЗМІ країн регіону', 2);
INSERT INTO dnamedic VALUES (302, 'Міжнародна інтеграція та глобалізація', 2);
INSERT INTO dnamedic VALUES (303, 'Міжнародні відносини та світова політика', 2);
INSERT INTO dnamedic VALUES (304, 'Міжнародні організації', 2);
INSERT INTO dnamedic VALUES (305, 'Основи етнології', 2);
INSERT INTO dnamedic VALUES (306, 'Основи культурології', 2);
INSERT INTO dnamedic VALUES (307, 'Основи міжнародного туризму', 2);
INSERT INTO dnamedic VALUES (308, 'Теорія міжнародних відносин', 2);
INSERT INTO dnamedic VALUES (309, 'Теорія та практика перекладу', 2);
INSERT INTO dnamedic VALUES (310, 'Цивілізації світу', 2);
INSERT INTO dnamedic VALUES (311, 'Комплексний державний екзамен зі спеціальності', 2);
INSERT INTO dnamedic VALUES (312, 'Основи охорони праці', 2);
INSERT INTO dnamedic VALUES (313, 'Демографічна і соціальна структура населення країн регіону', 2);
INSERT INTO dnamedic VALUES (314, 'Навчальна документознавча практика', 2);
INSERT INTO dnamedic VALUES (315, 'Етнологія та етнографія країн регіону', 2);
INSERT INTO dnamedic VALUES (316, 'Зовнішня політика країн регіону', 2);
INSERT INTO dnamedic VALUES (317, 'Культурні та духовно-релігійні традиції країн світу', 2);
INSERT INTO dnamedic VALUES (318, 'Навчальна музейно-екскурсійна практика', 2);
INSERT INTO dnamedic VALUES (319, 'Національна ідеологія та політичні еліти країн регіону', 2);
INSERT INTO dnamedic VALUES (320, 'Виробнича перекладацька практика', 2);
INSERT INTO dnamedic VALUES (321, 'Політико-правові системи країн регіону', 2);
INSERT INTO dnamedic VALUES (322, 'Навчальна практика з ЕОМ', 2);
INSERT INTO dnamedic VALUES (323, 'Туристичне країнознавство', 2);
INSERT INTO dnamedic VALUES (324, 'Основи культурології', 3);
INSERT INTO dnamedic VALUES (325, 'Методи соціальних досліджень', 3);
INSERT INTO dnamedic VALUES (326, 'Історія конституціоналізму України', 3);
INSERT INTO dnamedic VALUES (327, 'Методологія історії', 3);
INSERT INTO dnamedic VALUES (328, 'Основи фахової педагогічної майстерності', 3);
INSERT INTO dnamedic VALUES (329, 'Оглядові лекції', 3);
INSERT INTO dnamedic VALUES (330, 'Актуальні проблеми історії України', 3);
INSERT INTO dnamedic VALUES (331, 'Актуальні проблеми історії зарубіжних країн', 3);
INSERT INTO dnamedic VALUES (332, 'Інтелектуальна історія Європи', 3);
INSERT INTO dnamedic VALUES (333, 'Охорона праці в галузі', 3);
INSERT INTO dnamedic VALUES (334, 'Цивільний захист', 3);
INSERT INTO dnamedic VALUES (335, 'Інтелектуальна власність', 3);
INSERT INTO dnamedic VALUES (336, 'Православні церкви України (20-30-ті рр. ХХ ст.)', 3);
INSERT INTO dnamedic VALUES (337, 'Україна в загальноєвропейському інтеграційному процесі', 3);
INSERT INTO dnamedic VALUES (338, 'Проблеми прикордонного співробітництва країн Причорноморського регіону', 3);
INSERT INTO dnamedic VALUES (339, 'Історіографія історії Південної України', 3);
INSERT INTO dnamedic VALUES (340, 'Теорія та методика критичного мислення у процесі навчання історії', 3);
INSERT INTO dnamedic VALUES (341, 'Мультимедійні системи з історії', 3);
INSERT INTO dnamedic VALUES (342, 'Історія Олександрівська', 3);
INSERT INTO dnamedic VALUES (343, 'Запорізьке Придніпров''я (друга половина ХХ ст.)', 3);
INSERT INTO dnamedic VALUES (344, 'Історичні портрети політичних діячів Центральної та Південно-Східної Європи', 3);
INSERT INTO dnamedic VALUES (345, 'Гендерний фактор в європейській історії Середньовіччя та Нового часу', 3);
INSERT INTO dnamedic VALUES (346, 'Українські історичні школи', 3);
INSERT INTO dnamedic VALUES (347, 'Соціальна психологія та історія історичних наративів', 3);
INSERT INTO dnamedic VALUES (348, 'Виробнича педагогічна практика', 3);
INSERT INTO dnamedic VALUES (349, 'Переддипломна науково-дослідна практика', 3);
INSERT INTO dnamedic VALUES (350, 'Дипломна робота', 3);
INSERT INTO dnamedic VALUES (351, 'Теорія та методика архівознавства', 3);
INSERT INTO dnamedic VALUES (352, 'Архівне право та організація архівної справи', 3);
INSERT INTO dnamedic VALUES (353, 'Історія архівної справи', 3);
INSERT INTO dnamedic VALUES (354, 'Класифікація архівних документів', 3);
INSERT INTO dnamedic VALUES (355, 'Зарубіжна архівна україніка', 3);
INSERT INTO dnamedic VALUES (356, 'Актуальні проблеми зовнішньої політики країн/регіонів', 3);
INSERT INTO dnamedic VALUES (357, 'Актуальні проблеми зовнішньої політики України', 3);
INSERT INTO dnamedic VALUES (358, 'Проблеми національної та регіональної безпеки України', 3);
INSERT INTO dnamedic VALUES (359, 'Практикум перекладу', 3);
INSERT INTO dnamedic VALUES (360, 'Державний екзамен з практикуму перекладу', 3);
INSERT INTO dnamedic VALUES (361, 'Захист дипломної роботи', 3);
INSERT INTO dnamedic VALUES (362, 'Ділова риторика і міжкультурна комунікація', 3);
INSERT INTO dnamedic VALUES (363, 'Основи менеджменту ЗЕД', 3);
INSERT INTO dnamedic VALUES (364, 'Практикум перекладу (друга мова)', 3);
INSERT INTO dnamedic VALUES (365, 'Міжнародні організації в регіоні', 3);
INSERT INTO dnamedic VALUES (366, 'Виробнича переддипломна практика', 3);
INSERT INTO dnamedic VALUES (367, 'Ділова іноземна мова', 4);
INSERT INTO dnamedic VALUES (368, 'Теорія управління', 4);
INSERT INTO dnamedic VALUES (369, 'Педагогіка та психологія вищої школи', 4);
INSERT INTO dnamedic VALUES (370, 'Методологія історії', 4);
INSERT INTO dnamedic VALUES (371, 'Філософія історії', 4);
INSERT INTO dnamedic VALUES (372, 'Оглядові лекції', 4);
INSERT INTO dnamedic VALUES (373, 'Сучасна історіографія історії України', 4);
INSERT INTO dnamedic VALUES (374, 'Сучасна історіографія зарубіжних країн', 4);
INSERT INTO dnamedic VALUES (375, 'Актуальні проблеми джерелознавства та історіографії', 4);
INSERT INTO dnamedic VALUES (376, 'Методика викладання у вищій школі', 4);
INSERT INTO dnamedic VALUES (377, 'Вища освіта і Болонський процес', 4);
INSERT INTO dnamedic VALUES (378, 'Використання мережі Інтернет у вивченні і викладанні історії', 4);
INSERT INTO dnamedic VALUES (379, 'Компаративний аналіз політичних систем сучасного світу', 4);
INSERT INTO dnamedic VALUES (380, 'Зарубіжна історіграфія історії України', 4);
INSERT INTO dnamedic VALUES (381, 'Виробнича асистентська практика', 4);
INSERT INTO dnamedic VALUES (382, 'Магістерська науково-дослідна практика', 4);
INSERT INTO dnamedic VALUES (383, 'Магістерська робота', 4);
INSERT INTO dnamedic VALUES (384, 'Сучасне фондування та архівація службової документації', 4);
INSERT INTO dnamedic VALUES (385, 'Кіно-, фото-, фоноархіви та мікрокопіювання в Україні', 4);
INSERT INTO dnamedic VALUES (386, 'Палеографія та неографія', 2);
INSERT INTO dnamedic VALUES (387, 'Історія зарубіжної літератури', 2);
INSERT INTO dnamedic VALUES (388, 'Вступ до мовознавства', 2);
INSERT INTO dnamedic VALUES (389, 'Вступ до літературознавства', 2);
INSERT INTO dnamedic VALUES (390, 'Вступ до спецфілології', 2);
INSERT INTO dnamedic VALUES (391, 'Історія країни, мова якої вивчається ', 2);
INSERT INTO dnamedic VALUES (392, 'Історія мови', 2);
INSERT INTO dnamedic VALUES (394, 'Лінгвокраїнознавство', 2);
INSERT INTO dnamedic VALUES (395, 'Культурологія', 2);
INSERT INTO dnamedic VALUES (396, 'Методика викладання мови та літератури', 2);
INSERT INTO dnamedic VALUES (397, 'Основи інформатики та прикладної лінгвістики', 2);
INSERT INTO dnamedic VALUES (398, 'Основи психології та педагогіки', 2);
INSERT INTO dnamedic VALUES (399, 'Стилістика', 2);
INSERT INTO dnamedic VALUES (400, 'Сучасна українська література', 2);
INSERT INTO dnamedic VALUES (401, 'Теоретична граматика', 2);
INSERT INTO dnamedic VALUES (402, 'Теоретична фонетика', 2);
INSERT INTO dnamedic VALUES (403, 'Дискурсологія і текстологія', 2);
INSERT INTO dnamedic VALUES (404, 'Жанри та стилі', 2);
INSERT INTO dnamedic VALUES (405, 'Комп''ютерна обробка текстів та інформаційна культура студента', 2);
INSERT INTO dnamedic VALUES (406, 'Культура професійного мовлення', 2);
INSERT INTO dnamedic VALUES (407, 'Практика письмового мовлення з другої іноземної мови', 2);
INSERT INTO dnamedic VALUES (408, 'Практика письмової комунікації з основної іноземної мови  ', 2);
INSERT INTO dnamedic VALUES (409, 'Вступ до міжкультурної комунікації', 2);
INSERT INTO dnamedic VALUES (410, 'Основна іноземна  мова  з методикою викладання', 2);
INSERT INTO dnamedic VALUES (411, 'Особливості перекладу юридичних текстів', 2);
INSERT INTO dnamedic VALUES (412, 'Порівняльна граматика', 2);
INSERT INTO dnamedic VALUES (413, 'Порівняльна лексикологія', 2);
INSERT INTO dnamedic VALUES (414, 'Курсова робота з методики викладання мови та літератури ', 2);
INSERT INTO dnamedic VALUES (418, 'Курсова робота за фахом  ', 2);
INSERT INTO dnamedic VALUES (419, 'Варіативна частина (соціологія)', 2);
INSERT INTO dnamedic VALUES (420, 'Варіативна частина (етика та естетика)', 2);
INSERT INTO dnamedic VALUES (421, 'Варіативна частина (історія світової культури та мистецтва)', 2);
INSERT INTO dnamedic VALUES (422, 'Варіативна частина (правознавство)', 2);
INSERT INTO dnamedic VALUES (423, 'Варіативна частина (релігієзнавство)', 2);
INSERT INTO dnamedic VALUES (424, 'Варіативна частина (основи економічної теорії)', 2);
INSERT INTO dnamedic VALUES (425, 'Курсова робота з філології', 2);
INSERT INTO dnamedic VALUES (426, 'Курсова робота за фахом', 2);
INSERT INTO dnamedic VALUES (427, 'Курсова робота з перекладознавства', 2);
INSERT INTO dnamedic VALUES (428, 'Педагогічна практика', 2);
INSERT INTO dnamedic VALUES (429, 'Перекладацька практика', 2);
INSERT INTO dnamedic VALUES (430, 'Порівняльна стилістика', 2);
INSERT INTO dnamedic VALUES (431, 'Лексикографія', 2);
INSERT INTO dnamedic VALUES (432, 'Основи неології та проблеми неологізмів', 2);
INSERT INTO dnamedic VALUES (433, 'Особливості перекладу ділових паперів', 2);
INSERT INTO dnamedic VALUES (434, 'Практика перекладу', 2);
INSERT INTO dnamedic VALUES (435, 'Варіативна частина', 2);
INSERT INTO dnamedic VALUES (436, 'Варіативна частина (компаративістика)', 2);
INSERT INTO dnamedic VALUES (437, 'Вступ до перекладознавства', 2);
INSERT INTO dnamedic VALUES (438, 'Історія та теорія перекладу', 2);
INSERT INTO dnamedic VALUES (439, 'Курсова робота з перекладознавства', 2);
INSERT INTO dnamedic VALUES (440, 'Сучасні лінгвістичні наукові парадигми', 3);
INSERT INTO dnamedic VALUES (441, 'Література країни, мова якої вивчається', 3);
INSERT INTO dnamedic VALUES (442, 'Порівняльна граматика', 2);
INSERT INTO dnamedic VALUES (443, 'Порівняльна лексикологія', 2);
INSERT INTO dnamedic VALUES (444, 'Порівняльна стилістика', 2);
INSERT INTO dnamedic VALUES (445, 'Вступ до міжкультурної комунікації', 2);
INSERT INTO dnamedic VALUES (446, 'Лексикографія', 2);
INSERT INTO dnamedic VALUES (447, 'Основи неології та проблеми перекладу неологізмів', 2);
INSERT INTO dnamedic VALUES (448, 'Основи теорії мовної комунікації', 2);
INSERT INTO dnamedic VALUES (449, 'Особливості перекладу ділових паперів', 2);
INSERT INTO dnamedic VALUES (450, 'Практика перекладу', 2);
INSERT INTO dnamedic VALUES (451, 'Теорія літератури', 3);
INSERT INTO dnamedic VALUES (452, 'Теорія мовознавства', 3);
INSERT INTO dnamedic VALUES (453, 'Теорія другої мови', 3);
INSERT INTO dnamedic VALUES (454, 'Цивільний захист', 3);
INSERT INTO dnamedic VALUES (455, 'Теорія літератури', 3);
INSERT INTO dnamedic VALUES (456, 'Теорія мовознавства', 3);
INSERT INTO dnamedic VALUES (457, 'Теорія другої мови', 3);
INSERT INTO dnamedic VALUES (458, 'Основи художнього перекладу', 3);
INSERT INTO dnamedic VALUES (459, 'Особливості перекладу термінології ', 3);
INSERT INTO dnamedic VALUES (460, 'Проблеми перекладу в контексті міжкультурної комунікації', 3);
INSERT INTO dnamedic VALUES (461, 'Практика перекладу з основної мови (англійської) ', 3);
INSERT INTO dnamedic VALUES (462, 'Практика перекалду з основної мови (німецької)', 3);
INSERT INTO dnamedic VALUES (463, 'Соціолінгвістика', 3);
INSERT INTO dnamedic VALUES (464, 'Сучасні методології перекладу', 3);
INSERT INTO dnamedic VALUES (465, 'Методика викладання мови та літератури у вищій школі', 4);
INSERT INTO dnamedic VALUES (466, 'Педагогіка і психологія у вищій школі', 4);
INSERT INTO dnamedic VALUES (467, 'Класична мова', 4);
INSERT INTO dnamedic VALUES (468, 'Теорія мовознавства та історія лінгвістичних вчень', 4);
INSERT INTO dnamedic VALUES (469, 'Актуальні проблеми сучасної філології', 4);
INSERT INTO dnamedic VALUES (470, 'Регіональне варіювання мови', 4);
INSERT INTO dnamedic VALUES (471, 'Методика викладання перекладу у вищій школі', 4);
INSERT INTO dnamedic VALUES (472, 'Жанрові теорії перекладу', 4);
INSERT INTO dnamedic VALUES (473, 'Комунікативні стратегії', 4);
INSERT INTO dnamedic VALUES (474, 'Контрастивна лінгвістика', 4);
INSERT INTO dnamedic VALUES (475, 'Основи риторики', 4);
INSERT INTO dnamedic VALUES (476, 'Соціолінгвістичні проблеми перекладу', 4);
INSERT INTO dnamedic VALUES (477, 'Проблеми перекладу матеріалів сфери економіки та бізнесу ', 4);
INSERT INTO dnamedic VALUES (714, 'Фінансові послуги', 2);
INSERT INTO dnamedic VALUES (478, 'Проблеми перекладу науково-технічних текстів', 4);
INSERT INTO dnamedic VALUES (479, 'Проблеми художнього перекладу', 4);
INSERT INTO dnamedic VALUES (480, 'Історія релігії і церкви в Україні', 2);
INSERT INTO dnamedic VALUES (481, 'Массаж', 2);
INSERT INTO dnamedic VALUES (482, 'Активно-оздоровчий туризм', 2);
INSERT INTO dnamedic VALUES (483, 'Вступ до спеціальності', 2);
INSERT INTO dnamedic VALUES (484, 'Персонологія історії Південної України', 2);
INSERT INTO dnamedic VALUES (485, 'Історія міжнародних зв''язків України', 2);
INSERT INTO dnamedic VALUES (486, 'Соціологія масової комунікації', 2);
INSERT INTO dnamedic VALUES (487, 'Основи наукових досліджень', 2);
INSERT INTO dnamedic VALUES (488, 'Українська мова у професійному спілкуванні', 2);
INSERT INTO dnamedic VALUES (489, 'Практична стилістика', 2);
INSERT INTO dnamedic VALUES (490, 'Масова комунікація та інформація. Теорія масової комунікації', 2);
INSERT INTO dnamedic VALUES (491, 'Масова комунікація та інфоормація. Теорія масової інформації', 2);
INSERT INTO dnamedic VALUES (492, 'Масова комунікація та інформація. Комунікаційні технології', 2);
INSERT INTO dnamedic VALUES (493, 'Право в галузі реклами і зв''язків з громадськістю', 2);
INSERT INTO dnamedic VALUES (494, 'Основи реклами та ПР. Вступ до спеціальності', 2);
INSERT INTO dnamedic VALUES (495, 'Основи реклами та ПР. Комп''ютерно-технічні засоби в ркламі та ПР', 2);
INSERT INTO dnamedic VALUES (496, 'Етика в рекламній та ПР-діяльності', 2);
INSERT INTO dnamedic VALUES (497, 'Теорі реклами та зв''язків з громадськістю. Теорія ПР', 2);
INSERT INTO dnamedic VALUES (498, 'Теорія реклами і зв''язків з громадськістю. Теорія реклами', 2);
INSERT INTO dnamedic VALUES (499, 'Теорія реклами і зв''язків з громадськістю. Теорія і методика рекламної та ПР творчості', 2);
INSERT INTO dnamedic VALUES (500, 'Теорія реклами і зв''язків з громадськістю. Брендинг', 2);
INSERT INTO dnamedic VALUES (501, 'Історія реклами', 2);
INSERT INTO dnamedic VALUES (502, 'Історія ПР', 2);
INSERT INTO dnamedic VALUES (503, 'Безпка життєдіяльності', 2);
INSERT INTO dnamedic VALUES (504, 'Зарубіжна реклама і ПР', 2);
INSERT INTO dnamedic VALUES (505, 'Професійна підготовка. Практика рекламної діяльності', 2);
INSERT INTO dnamedic VALUES (506, 'Професійна підготовка. Практика ПР-діяльності', 2);
INSERT INTO dnamedic VALUES (507, 'Професійна підготовка. Організація роботи прес-служби', 2);
INSERT INTO dnamedic VALUES (508, 'Професійна підготовка. Копірайтинг та дизайн у рекламі та ПР', 2);
INSERT INTO dnamedic VALUES (509, 'Професійна підготовка. Іміджологія', 2);
INSERT INTO dnamedic VALUES (510, 'Професійна підготовка. Кваліфікаційна робота', 2);
INSERT INTO dnamedic VALUES (511, 'Зовнішня політика США', 2);
INSERT INTO dnamedic VALUES (512, 'Соціологія громадської думки', 3);
INSERT INTO dnamedic VALUES (513, 'Теорія та історія соціальних комунікацій', 3);
INSERT INTO dnamedic VALUES (514, 'Теорія та історія реклами', 3);
INSERT INTO dnamedic VALUES (515, 'Посади для фахівців з реклами', 3);
INSERT INTO dnamedic VALUES (516, 'Переддипломна виробнича практика', 3);
INSERT INTO dnamedic VALUES (517, 'Дипломна робота', 3);
INSERT INTO dnamedic VALUES (518, 'Наукове спілкування іноземною мовою', 4);
INSERT INTO dnamedic VALUES (519, 'Управління персоналом', 4);
INSERT INTO dnamedic VALUES (520, 'Теорія та історія соціальних комунікацій', 4);
INSERT INTO dnamedic VALUES (521, 'Документознавство та архівознавство', 4);
INSERT INTO dnamedic VALUES (522, 'Книгознавство та біліотекознавство', 4);
INSERT INTO dnamedic VALUES (523, 'Теорія та історія журналістики', 4);
INSERT INTO dnamedic VALUES (524, 'Теорія та історія видавничої справи та редагування', 4);
INSERT INTO dnamedic VALUES (525, 'Прикладні соціально-комунікаційні технології', 4);
INSERT INTO dnamedic VALUES (526, 'Соціальна інформатика', 4);
INSERT INTO dnamedic VALUES (527, 'Методологія досліджень соціальних комунікацій', 4);
INSERT INTO dnamedic VALUES (528, 'Методика викладання фахових  дисциплін', 4);
INSERT INTO dnamedic VALUES (529, 'Методика та організація наукових досліджень', 4);
INSERT INTO dnamedic VALUES (530, 'Магістерська дисертація', 4);
INSERT INTO dnamedic VALUES (531, 'Методологія і організація наукових досліджень', 4);
INSERT INTO dnamedic VALUES (532, 'Історія української культури', 2);
INSERT INTO dnamedic VALUES (533, 'Варіативна частина. Психологія', 2);
INSERT INTO dnamedic VALUES (534, 'Варіативна частина. Соціологія', 2);
INSERT INTO dnamedic VALUES (535, 'Основи наукових досліджень та інформаційна культура студента', 2);
INSERT INTO dnamedic VALUES (536, 'Журналістський фах. Агенційна журналістика', 2);
INSERT INTO dnamedic VALUES (537, 'Основи журналістики. Вступ до спеціальності', 2);
INSERT INTO dnamedic VALUES (538, 'Журналістський фах. Газетно-журнальне виробництво', 2);
INSERT INTO dnamedic VALUES (539, 'Журналістська етика', 2);
INSERT INTO dnamedic VALUES (540, 'Журналістський фах', 2);
INSERT INTO dnamedic VALUES (541, 'Історія української журналістики', 2);
INSERT INTO dnamedic VALUES (542, 'Масова комунікація та інформація. Комунікаційні технології', 2);
INSERT INTO dnamedic VALUES (543, 'Масова комунікація та інформація', 2);
INSERT INTO dnamedic VALUES (544, 'Масова комунікація та інформація. Теорія масової комунікації', 2);
INSERT INTO dnamedic VALUES (545, 'Масова комунікація та інформація. Теорія масової інформації', 2);
INSERT INTO dnamedic VALUES (546, 'Медіабезпека (безпека життєдіяльності)', 2);
INSERT INTO dnamedic VALUES (547, 'Журналістикознавство. Медіакритика', 2);
INSERT INTO dnamedic VALUES (548, ' Медіаправо', 2);
INSERT INTO dnamedic VALUES (549, 'Економічна теорія', 2);
INSERT INTO dnamedic VALUES (550, 'Мікроекономіка', 2);
INSERT INTO dnamedic VALUES (551, 'Макроекономіка', 2);
INSERT INTO dnamedic VALUES (552, 'Історія економіки та економічної думки', 2);
INSERT INTO dnamedic VALUES (553, 'Вища математика', 2);
INSERT INTO dnamedic VALUES (554, 'Міжнародна журналістика', 2);
INSERT INTO dnamedic VALUES (555, 'Навчально-виробнича практика', 2);
INSERT INTO dnamedic VALUES (556, 'Теорія ймовірності та математична статистика', 2);
INSERT INTO dnamedic VALUES (557, 'Основи журналістики', 2);
INSERT INTO dnamedic VALUES (558, 'Практична стилістика', 2);
INSERT INTO dnamedic VALUES (559, 'Оптимізаційні методи і моделі', 2);
INSERT INTO dnamedic VALUES (560, 'Економетрика', 2);
INSERT INTO dnamedic VALUES (561, 'Журналістський фах. Радіовиробництво', 2);
INSERT INTO dnamedic VALUES (562, 'Журналістський фах. Телевиробництво', 2);
INSERT INTO dnamedic VALUES (563, 'Інформатика', 2);
INSERT INTO dnamedic VALUES (564, 'Журналістикознавство. Теорія журналістики', 2);
INSERT INTO dnamedic VALUES (565, 'Журналістикознавство. Теорія і методика журналістської творчості', 2);
INSERT INTO dnamedic VALUES (566, 'Основи журналістики. Технічні засоби виробництва', 2);
INSERT INTO dnamedic VALUES (567, 'Журналістський фах. Фотожурналістика', 2);
INSERT INTO dnamedic VALUES (568, 'Журналістикознавство. Теорія твору і тексту', 2);
INSERT INTO dnamedic VALUES (569, 'Історія зарубіжної журналістики', 2);
INSERT INTO dnamedic VALUES (570, 'Журналістикознавство', 2);
INSERT INTO dnamedic VALUES (571, 'Історія української журналістики ХХ сторіччя', 2);
INSERT INTO dnamedic VALUES (572, 'Фольклор і давня література', 2);
INSERT INTO dnamedic VALUES (573, 'Іноземна мова (додатковий курс)', 2);
INSERT INTO dnamedic VALUES (574, 'Видавнича справа та редагування', 2);
INSERT INTO dnamedic VALUES (575, 'Проблематика засобів масової інформації. Політична та економічна проблематика ', 2);
INSERT INTO dnamedic VALUES (576, 'Проблематика засобів масової інформації. Правова та соціальна проблематика', 2);
INSERT INTO dnamedic VALUES (577, 'Проблематика засобів масової інформації. Міжнародна проблематика', 2);
INSERT INTO dnamedic VALUES (578, 'Проблематика засобів масової інформації. Спортивна проблематика', 2);
INSERT INTO dnamedic VALUES (579, 'Реклама та зв''язки з громадськістю', 2);
INSERT INTO dnamedic VALUES (580, 'Інтернет-журналістика. Веб-сайт як інтернет-ЗМІ', 2);
INSERT INTO dnamedic VALUES (581, 'Газетно-журнальний менеджмент', 2);
INSERT INTO dnamedic VALUES (582, 'Журналістське розслідування', 2);
INSERT INTO dnamedic VALUES (583, 'Інтернет-журналістика. Оптимізація роботи інтернет-видання', 2);
INSERT INTO dnamedic VALUES (584, 'Інтрнет-журналістика. Мультимедійність в інтернет-журналістиці', 2);
INSERT INTO dnamedic VALUES (585, 'Державне регулювання економіки', 2);
INSERT INTO dnamedic VALUES (586, 'Економічний ризик та його оцінка', 2);
INSERT INTO dnamedic VALUES (587, 'Економічний аналіз', 2);
INSERT INTO dnamedic VALUES (588, 'Економіка і організація інноваційної діяльності', 2);
INSERT INTO dnamedic VALUES (589, 'Функціонування багатосторонньої торгівельної системи СОТ', 2);
INSERT INTO dnamedic VALUES (590, 'Фінансова статистика і математика', 2);
INSERT INTO dnamedic VALUES (591, 'Курсова робота з дисципліни "Теорія і методика журналістської творчості"', 2);
INSERT INTO dnamedic VALUES (592, 'Літературний стиль', 2);
INSERT INTO dnamedic VALUES (593, 'Медіакультура', 2);
INSERT INTO dnamedic VALUES (594, 'Музичний редактор на радіо', 2);
INSERT INTO dnamedic VALUES (595, 'Особливості мови та сприйняття радіомовлення', 2);
INSERT INTO dnamedic VALUES (596, 'Преса. Газетно-журнальні жанри', 2);
INSERT INTO dnamedic VALUES (597, 'Радіомовлення. Інформаційне радіомовлення', 2);
INSERT INTO dnamedic VALUES (598, 'Спеціалізація', 2);
INSERT INTO dnamedic VALUES (599, 'Сучасна зарубіжна публіцистика', 2);
INSERT INTO dnamedic VALUES (600, 'Сучасна українська публіцистика', 2);
INSERT INTO dnamedic VALUES (601, 'Телебачення. Режисер на телебаченні', 2);
INSERT INTO dnamedic VALUES (602, 'Телебачення. Телевізійні жарни', 2);
INSERT INTO dnamedic VALUES (603, 'Телебачення. Технологія створення аудіовізуального продукту', 2);
INSERT INTO dnamedic VALUES (604, 'Основи інтернет-журналістики', 2);
INSERT INTO dnamedic VALUES (605, 'Особливості форматування сучасного радіомовлення', 2);
INSERT INTO dnamedic VALUES (606, 'ЗМІ Запорізького регіону', 2);
INSERT INTO dnamedic VALUES (607, 'Сучасний медіаринок України', 2);
INSERT INTO dnamedic VALUES (608, 'Лінгвістичні основи соціальної комунікації', 2);
INSERT INTO dnamedic VALUES (609, 'Російська мова в засобах масової комунікації', 2);
INSERT INTO dnamedic VALUES (610, 'Спецкурс. Книжкові проекти газети "День"', 2);
INSERT INTO dnamedic VALUES (611, 'Постановка голосу', 2);
INSERT INTO dnamedic VALUES (612, 'Спецкурс. Дизайн друкованого видання', 2);
INSERT INTO dnamedic VALUES (613, 'Спецкурс. Журналістсько-літературна діяльність Р. Федоріва', 2);
INSERT INTO dnamedic VALUES (614, 'Спецкурс. Чорнобильська журналістика', 2);
INSERT INTO dnamedic VALUES (615, 'Спецкурс. Преса п''яти континентів', 2);
INSERT INTO dnamedic VALUES (616, 'Спецкурс', 2);
INSERT INTO dnamedic VALUES (617, 'Спецкурс. Культура професійного мовлення', 2);
INSERT INTO dnamedic VALUES (618, 'Спецкурс. Риторичні основи журналістики', 2);
INSERT INTO dnamedic VALUES (619, 'Спецкурс. Літературно-мистецьке життя в Україні', 2);
INSERT INTO dnamedic VALUES (620, 'Спецкурс. Глобальні телемережі новин у світовому інформаційному просторі', 2);
INSERT INTO dnamedic VALUES (621, 'Навчально-ознайомлювальна практика (з відривом від навчання)', 2);
INSERT INTO dnamedic VALUES (622, 'Навчально-ознайомлювальна практика (без відриву від навчання)', 2);
INSERT INTO dnamedic VALUES (623, 'Новітні медіа', 2);
INSERT INTO dnamedic VALUES (715, 'Фінансовий менеджмент', 2);
INSERT INTO dnamedic VALUES (624, 'Прес-служби та інформаційні агентства', 2);
INSERT INTO dnamedic VALUES (625, 'Студійний практикум', 2);
INSERT INTO dnamedic VALUES (626, 'Економіка підприємства', 2);
INSERT INTO dnamedic VALUES (627, 'Журналістська майстерність', 2);
INSERT INTO dnamedic VALUES (628, 'Менеджмент', 2);
INSERT INTO dnamedic VALUES (629, 'Маркетинг', 2);
INSERT INTO dnamedic VALUES (630, 'Гроші і кредит', 2);
INSERT INTO dnamedic VALUES (631, 'Фінанси', 2);
INSERT INTO dnamedic VALUES (632, 'Бухгалтерський облік', 2);
INSERT INTO dnamedic VALUES (633, 'Економіка праці і соціально-трудові відносини', 2);
INSERT INTO dnamedic VALUES (634, 'Міжнародна економіка', 2);
INSERT INTO dnamedic VALUES (635, 'Статистика', 2);
INSERT INTO dnamedic VALUES (636, 'Соціологія', 2);
INSERT INTO dnamedic VALUES (637, 'Регіональна економіка', 2);
INSERT INTO dnamedic VALUES (638, 'Варіативна частина', 2);
INSERT INTO dnamedic VALUES (639, 'Безпека життєдіяльності', 2);
INSERT INTO dnamedic VALUES (640, 'Банківська система', 2);
INSERT INTO dnamedic VALUES (641, 'Вступ до фаху "Видавнича справа та редагування" (коректура, поліграфія)', 2);
INSERT INTO dnamedic VALUES (642, 'Бюджетна система', 2);
INSERT INTO dnamedic VALUES (643, 'Податкова система', 2);
INSERT INTO dnamedic VALUES (644, 'Страхування', 2);
INSERT INTO dnamedic VALUES (645, 'Газетно-журнальні видання', 2);
INSERT INTO dnamedic VALUES (646, 'Фінанси підприємств', 2);
INSERT INTO dnamedic VALUES (647, 'Електронні видання', 2);
INSERT INTO dnamedic VALUES (648, 'Фінансовий ринок', 2);
INSERT INTO dnamedic VALUES (649, 'Інвестування', 2);
INSERT INTO dnamedic VALUES (650, ' Історія світової видавничої справи', 2);
INSERT INTO dnamedic VALUES (651, 'Історія української видавничой справи', 2);
INSERT INTO dnamedic VALUES (652, 'Виробнича практика: економічна', 2);
INSERT INTO dnamedic VALUES (653, 'Книжкові видання', 2);
INSERT INTO dnamedic VALUES (654, 'Комп''ютерна графіка', 2);
INSERT INTO dnamedic VALUES (655, 'Основи охорони праці', 2);
INSERT INTO dnamedic VALUES (656, 'Комунікаційні технології', 2);
INSERT INTO dnamedic VALUES (657, 'Культура видання. Видавничі стандарти', 2);
INSERT INTO dnamedic VALUES (658, 'Макети та верстка', 2);
INSERT INTO dnamedic VALUES (659, 'Маркетинг і промоція видань', 2);
INSERT INTO dnamedic VALUES (660, 'Масова комунікація та інформація', 2);
INSERT INTO dnamedic VALUES (661, 'Масова комунікація та інформація. Теорія масової інформації', 2);
INSERT INTO dnamedic VALUES (662, 'Масова комунікація та інформація. Теорія масової комунікації', 2);
INSERT INTO dnamedic VALUES (663, 'Основи видавничої справи', 2);
INSERT INTO dnamedic VALUES (664, 'Основи редагування', 2);
INSERT INTO dnamedic VALUES (665, 'Право видавця та редактора', 2);
INSERT INTO dnamedic VALUES (666, 'Редакторсько-видавничий фах', 2);
INSERT INTO dnamedic VALUES (667, 'Текстознавство', 2);
INSERT INTO dnamedic VALUES (668, 'Шрифтознавство', 2);
INSERT INTO dnamedic VALUES (669, 'Видавничий ринок Запоріжжя', 2);
INSERT INTO dnamedic VALUES (670, 'Фольклор і давня література', 2);
INSERT INTO dnamedic VALUES (671, 'Основи професійної комунікації', 2);
INSERT INTO dnamedic VALUES (672, 'Стилістичні функції тексту', 2);
INSERT INTO dnamedic VALUES (673, 'Теорія та практика перекладу', 2);
INSERT INTO dnamedic VALUES (674, 'Термінологічний практикум', 2);
INSERT INTO dnamedic VALUES (675, 'Український правопис', 2);
INSERT INTO dnamedic VALUES (676, 'Брошури, ілюстрації, листівки, плакати', 2);
INSERT INTO dnamedic VALUES (677, 'Довідково-енциклопедичні та рекламні видання', 2);
INSERT INTO dnamedic VALUES (678, 'Загальна і спеціальна бібліографія', 2);
INSERT INTO dnamedic VALUES (679, 'Історичні постаті видавничої справи', 2);
INSERT INTO dnamedic VALUES (680, 'Культура професійного мовлення', 2);
INSERT INTO dnamedic VALUES (681, 'Літературне редагування', 2);
INSERT INTO dnamedic VALUES (682, 'Логічні методи аналізу тексту', 2);
INSERT INTO dnamedic VALUES (683, 'Навчальні, наукові, науково-популярні видання', 2);
INSERT INTO dnamedic VALUES (684, 'Основи технічної естетики та дизайну видання', 2);
INSERT INTO dnamedic VALUES (685, 'Офіційні та нормативні видання', 2);
INSERT INTO dnamedic VALUES (686, 'Переклади та перевидання', 2);
INSERT INTO dnamedic VALUES (687, 'Підтримка сайту', 2);
INSERT INTO dnamedic VALUES (688, 'Поліграфічне виробництво', 2);
INSERT INTO dnamedic VALUES (689, 'Спеціалізація', 2);
INSERT INTO dnamedic VALUES (690, 'Типологія помилок', 2);
INSERT INTO dnamedic VALUES (691, 'Функціонування видавничих структур', 2);
INSERT INTO dnamedic VALUES (692, 'Художне та технічне редагування', 2);
INSERT INTO dnamedic VALUES (693, 'Бізнес планування', 2);
INSERT INTO dnamedic VALUES (694, 'Еристика. Теорія і практика аргументації', 2);
INSERT INTO dnamedic VALUES (695, 'Етичні та тикетні норми видавничої діяльності', 2);
INSERT INTO dnamedic VALUES (696, 'Журналістика', 2);
INSERT INTO dnamedic VALUES (697, 'Кваліологія видання', 3);
INSERT INTO dnamedic VALUES (698, 'Культура наукового мовлення', 3);
INSERT INTO dnamedic VALUES (699, 'Мас-медіа і міжкультурна комунікація', 3);
INSERT INTO dnamedic VALUES (700, 'Промоція видавничої продукції', 3);
INSERT INTO dnamedic VALUES (701, 'Теорія та історія видавничої справи та редагування', 3);
INSERT INTO dnamedic VALUES (702, 'Теорія та історія соціальних комунікацій', 3);
INSERT INTO dnamedic VALUES (703, 'Посади для фахівців з видавничої справи', 3);
INSERT INTO dnamedic VALUES (704, 'Ілюстрування друкованих видань', 3);
INSERT INTO dnamedic VALUES (705, 'Риторика', 3);
INSERT INTO dnamedic VALUES (706, 'Фінансово-економічна безпека', 2);
INSERT INTO dnamedic VALUES (707, 'Фінансові системи зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (708, 'Аналіз інвестиційних проектів', 2);
INSERT INTO dnamedic VALUES (709, 'Інформаційні системи в фінансових установах', 2);
INSERT INTO dnamedic VALUES (710, 'Фінансовий аналіз', 2);
INSERT INTO dnamedic VALUES (711, 'Банківські операції', 2);
INSERT INTO dnamedic VALUES (712, 'Платіжні системи', 2);
INSERT INTO dnamedic VALUES (713, 'Біржові операції', 2);
INSERT INTO dnamedic VALUES (716, 'Міжнародні фінанси', 2);
INSERT INTO dnamedic VALUES (717, 'Кредитування і контроль', 2);
INSERT INTO dnamedic VALUES (718, 'Банківський менеджмент', 2);
INSERT INTO dnamedic VALUES (719, 'Страхові послуги', 2);
INSERT INTO dnamedic VALUES (720, 'Вступ до спеціальності та інформаційна культура студента', 2);
INSERT INTO dnamedic VALUES (721, 'Аналіз фондового ринку', 2);
INSERT INTO dnamedic VALUES (722, 'Державний екзамен з економічної теорії', 2);
INSERT INTO dnamedic VALUES (723, 'Комплексний державний екзамен за фахом', 2);
INSERT INTO dnamedic VALUES (724, 'Міжнародні транспортні перевезення ', 2);
INSERT INTO dnamedic VALUES (725, 'Брендинг', 2);
INSERT INTO dnamedic VALUES (726, 'Іміджологія', 2);
INSERT INTO dnamedic VALUES (727, 'Основи реклами та ПР', 2);
INSERT INTO dnamedic VALUES (728, 'Теорія реклами та зв''язків з громадськістю', 2);
INSERT INTO dnamedic VALUES (729, 'Професійна підготовка', 2);
INSERT INTO dnamedic VALUES (730, 'Галузева реклама і ПР. Літературна проблематика', 2);
INSERT INTO dnamedic VALUES (731, 'Галузева реклама і ПР. Міжнародна тематика', 2);
INSERT INTO dnamedic VALUES (732, 'Галузева реклама і ПР. Політична і економічна проблматика', 2);
INSERT INTO dnamedic VALUES (733, 'Галузева реклама і ПР. Правова проблематика', 2);
INSERT INTO dnamedic VALUES (734, 'Галузева реклама і ПР. Соціальна проблематика', 2);
INSERT INTO dnamedic VALUES (735, 'Креатив у рекламі та ПР', 2);
INSERT INTO dnamedic VALUES (736, 'Макетування та верстка в рекламній та ПР діяльності', 2);
INSERT INTO dnamedic VALUES (737, 'Медіапланування', 2);
INSERT INTO dnamedic VALUES (738, 'Організація ПР-кампанії', 2);
INSERT INTO dnamedic VALUES (739, 'Організація рекламної кампанії', 2);
INSERT INTO dnamedic VALUES (740, 'Організація роботи ПР-агенції', 2);
INSERT INTO dnamedic VALUES (741, 'Організація роботи рекламної агенції', 2);
INSERT INTO dnamedic VALUES (742, 'ПР-жанри та ПР-технології', 2);
INSERT INTO dnamedic VALUES (743, 'Реклама у мас-медіа та інтернеті', 2);
INSERT INTO dnamedic VALUES (744, 'Соціологія рекламної діяльності', 2);
INSERT INTO dnamedic VALUES (745, 'Спеціалізація. Реклама', 2);
INSERT INTO dnamedic VALUES (746, 'Спеціалізація. Зв''язки з громадськістю', 2);
INSERT INTO dnamedic VALUES (747, 'Спічрайтинг', 2);
INSERT INTO dnamedic VALUES (748, 'Теорія і практика журналістської діяльності', 2);
INSERT INTO dnamedic VALUES (749, 'Сучасна реклама', 2);
INSERT INTO dnamedic VALUES (750, 'Сучасний ПР', 2);
INSERT INTO dnamedic VALUES (751, 'Рекламний ринок Запоріжжя', 2);
INSERT INTO dnamedic VALUES (752, 'Рекламний ринок України', 2);
INSERT INTO dnamedic VALUES (753, 'Психологічні основи реклами та ПР', 2);
INSERT INTO dnamedic VALUES (754, 'Історія світової видавничої справи', 2);
INSERT INTO dnamedic VALUES (755, 'Технічні засоби виробництва (додатковий курс)', 2);
INSERT INTO dnamedic VALUES (756, 'Проблематика ЗМІ. Економічна проблематика', 2);
INSERT INTO dnamedic VALUES (757, 'Курсова робота зі спціалізації', 2);
INSERT INTO dnamedic VALUES (758, 'Спеціалізаія. Художньо-технічне оформлення газети', 2);
INSERT INTO dnamedic VALUES (759, 'Спеціалізація. Журнали на сучасному ринку преси', 2);
INSERT INTO dnamedic VALUES (760, 'Спеціалізація. Інтернет-журналістика. Конвергентний ньюзрум', 2);
INSERT INTO dnamedic VALUES (761, 'Спціалізація. Інформаційне телебачення', 2);
INSERT INTO dnamedic VALUES (762, 'Спеціалізація. Режисер на телебаченні', 2);
INSERT INTO dnamedic VALUES (763, 'Спеціалізація. Ведучий на телебаченні', 2);
INSERT INTO dnamedic VALUES (764, 'Сучасна українська та зарубіжна публіцистика', 2);
INSERT INTO dnamedic VALUES (765, 'Курсова робота з дисципліни "Організація підприємницької діяльності у виробничій сфері"', 2);
INSERT INTO dnamedic VALUES (766, 'Логістика на ринку товарів та послуг', 2);
INSERT INTO dnamedic VALUES (767, 'Маркетингова діяльність підприємства на ринку готельного, туристичного та курортного сервісу', 2);
INSERT INTO dnamedic VALUES (768, 'Менеджмент підприємства у виробничій сфері', 2);
INSERT INTO dnamedic VALUES (769, 'Економічна безпека підприємств', 2);
INSERT INTO dnamedic VALUES (770, 'Товарознавство', 2);
INSERT INTO dnamedic VALUES (771, 'Курсова робота з дисципліни "організація підприємницької діяльності у сфері готельного, туристичного', 2);
INSERT INTO dnamedic VALUES (772, 'Курсова робота з дисципліни "Організація підприємницької діяльності на ринку товарів та послуг"', 2);
INSERT INTO dnamedic VALUES (773, 'Організація підприємницької діяльності у виробничій сфері', 2);
INSERT INTO dnamedic VALUES (774, 'Організація підприємницької діяльності у сфері готельного,туристичного та курортного сервісу', 2);
INSERT INTO dnamedic VALUES (775, 'Організація підприємницької діяльності на ринку товарів та послуг', 2);
INSERT INTO dnamedic VALUES (776, 'Економіка підприємства у виробничій сфері', 2);
INSERT INTO dnamedic VALUES (777, 'Економіка підприємства на ринку готельного, туристичного, курортного сервісу', 2);
INSERT INTO dnamedic VALUES (778, 'Економіка торгівельного підприємства', 2);
INSERT INTO dnamedic VALUES (779, 'Формування іміджу організацій', 2);
INSERT INTO dnamedic VALUES (780, 'Логістика у виробничій сфері', 2);
INSERT INTO dnamedic VALUES (781, 'Логістика у сфері готельного, туристичного та курортного сервісу', 2);
INSERT INTO dnamedic VALUES (782, 'Менеджмент підприємства у сфері готельного, туристичного та курортного сервісу', 2);
INSERT INTO dnamedic VALUES (783, 'Менеджмент підприємства на ринку товарів та послуг', 2);
INSERT INTO dnamedic VALUES (784, 'Маркетингова діяльність підприємства у виробничій сфері', 2);
INSERT INTO dnamedic VALUES (785, 'Маркетингова діяльність підприємства на ринку товарів та послуг', 2);
INSERT INTO dnamedic VALUES (786, 'Технологія продуктів харчування', 2);
INSERT INTO dnamedic VALUES (787, 'Економіка підприємств на ринку готельного і ресторанного сервісу', 2);
INSERT INTO dnamedic VALUES (788, 'Курсова робота з дисципліни "Організація підприємницької діяльності на ринку готельного та ресторанн', 2);
INSERT INTO dnamedic VALUES (789, 'Логістика у сфері готельного та ресторанного сервісу', 2);
INSERT INTO dnamedic VALUES (790, 'Маркетингова діяльність підприємства у сфері готельного та ресторанного сервісу', 2);
INSERT INTO dnamedic VALUES (791, 'Менеджмент підприємств в сфері готельного та ресторанного сервісу', 2);
INSERT INTO dnamedic VALUES (792, 'Організація підприємницької діяльності на ринку готельного і ресторанного сервісу', 2);
INSERT INTO dnamedic VALUES (793, 'Організація обслуговування в ресторанному господарстві', 2);
INSERT INTO dnamedic VALUES (794, 'Історія сучасного світу', 2);
INSERT INTO dnamedic VALUES (795, 'Міжкультурна комунікація', 2);
INSERT INTO dnamedic VALUES (796, 'Релігієзнавство', 2);
INSERT INTO dnamedic VALUES (797, 'Вища і прикладна математика (вкл.мод. "Математичне програмування", "Теорія ймовірностей")', 2);
INSERT INTO dnamedic VALUES (798, 'Інформаційні системи і технології', 2);
INSERT INTO dnamedic VALUES (799, 'Статистика (вкл.мод. Економічна статистика)', 2);
INSERT INTO dnamedic VALUES (800, 'Економіка і фінанси підприємства', 2);
INSERT INTO dnamedic VALUES (801, 'Операційний менеджмент', 2);
INSERT INTO dnamedic VALUES (802, 'Державне та регіональне управління', 2);
INSERT INTO dnamedic VALUES (803, 'Економетрія', 2);
INSERT INTO dnamedic VALUES (804, 'Економіка зарубіжних країн', 2);
INSERT INTO dnamedic VALUES (805, 'Економічна інформатика', 2);
INSERT INTO dnamedic VALUES (806, 'Зовнішньоекономічна діяльність підприємств', 2);
INSERT INTO dnamedic VALUES (807, 'Логістика', 2);
INSERT INTO dnamedic VALUES (808, 'Маркетинг (вкл.мод. "Маркетингові дослідження ринку")', 2);
INSERT INTO dnamedic VALUES (809, 'Моделювання економічних процесів', 2);
INSERT INTO dnamedic VALUES (810, 'Правознавство', 2);
INSERT INTO dnamedic VALUES (811, 'Адміністративний менеджмент', 2);
INSERT INTO dnamedic VALUES (812, 'Фінанси, гроші та кредит', 2);
INSERT INTO dnamedic VALUES (813, 'Виробнича управлінська практика', 2);
INSERT INTO dnamedic VALUES (814, 'Облік і аудит', 2);
INSERT INTO dnamedic VALUES (815, 'Самоменеджмент', 2);
INSERT INTO dnamedic VALUES (816, 'Стратегічне управління', 2);
INSERT INTO dnamedic VALUES (817, 'Теорія організацій', 2);
INSERT INTO dnamedic VALUES (818, 'Управління іноваціями', 2);
INSERT INTO dnamedic VALUES (819, 'Навчальна практика "Вступ до фаху"', 2);
INSERT INTO dnamedic VALUES (820, 'Системи технологій', 2);
INSERT INTO dnamedic VALUES (821, 'Теорія економічного аналізу', 2);
INSERT INTO dnamedic VALUES (822, 'Аналіз господарської діяльності', 2);
INSERT INTO dnamedic VALUES (823, 'Англійська мова ділової комунікації (вкл.мод. "Ділова кореспонденція і протоколи")', 2);
INSERT INTO dnamedic VALUES (824, 'Діловодство', 2);
INSERT INTO dnamedic VALUES (825, 'Етика бізнесу', 2);
INSERT INTO dnamedic VALUES (826, 'Інфраструктура ринку', 2);
INSERT INTO dnamedic VALUES (827, 'Контролінг', 2);
INSERT INTO dnamedic VALUES (828, 'Курсова робота з диципліни "Менеджмент"', 2);
INSERT INTO dnamedic VALUES (829, 'Організаційна поведінка', 2);
INSERT INTO dnamedic VALUES (830, 'Основи ділової комунікації (вкл.мод "Сучасні комунікаційні технології")', 2);
INSERT INTO dnamedic VALUES (831, 'Теорія галузевих ринків', 2);
INSERT INTO dnamedic VALUES (832, 'Курсова робота з дисципліни "Теорія організацій"', 2);
INSERT INTO dnamedic VALUES (833, 'Електронна комерція', 2);
INSERT INTO dnamedic VALUES (834, 'Державний екзамен', 2);
INSERT INTO dnamedic VALUES (835, 'Іноземна мова (за професійним спрямуванням)', 2);


--
-- Name: dnamedic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dnamedic_id', 1, false);


--
-- Data for Name: dsubtypedic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO dsubtypedic VALUES (1, '1.1. Гуманітарні та соціально-економічні дисципліни', 1);
INSERT INTO dsubtypedic VALUES (2, '1.2. Дисципліни природничо-наукової (фундаментальної) підготовки ', 1);
INSERT INTO dsubtypedic VALUES (3, '1.3. Дисципліни загально-професійної підготовки', 1);
INSERT INTO dsubtypedic VALUES (4, '1.4. Дисципліни професійної і практичної підготовки', 1);
INSERT INTO dsubtypedic VALUES (5, '2.1. Дисципліни самостійного вибору навчального закладу', 2);
INSERT INTO dsubtypedic VALUES (6, '2.1.1. Гуманітарні та соціально-економічні дисципліни', 2);
INSERT INTO dsubtypedic VALUES (7, '2.1.2. Дисципліни природничо-наукової (фундаментальної) підготовки', 2);
INSERT INTO dsubtypedic VALUES (8, '2.1.3. Дисципліни загально-професійної підготовки', 2);
INSERT INTO dsubtypedic VALUES (9, '2.1.4. Дисципліни професійної і практичної підготовки', 2);
INSERT INTO dsubtypedic VALUES (11, '2.2.3. Дисципліни загально-професійної підготовки', 2);
INSERT INTO dsubtypedic VALUES (12, '2.2.4. Дисципліни професійної і практичної підготовки', 2);
INSERT INTO dsubtypedic VALUES (13, '2.2.5.Гуманітарні та соціально-економічні дисципліни', 2);
INSERT INTO dsubtypedic VALUES (15, '1.2. Цикл фундаментальної, природничо-наукової та загальноекономічної підготовки', 1);
INSERT INTO dsubtypedic VALUES (14, '1.1.  Цикл соціально-гуманітарної підготовки', 1);


--
-- Name: dsubtypedic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dsubtypedic_id', 16, true);


--
-- Data for Name: gzdic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO gzdic VALUES (1, '0101 Педагогічна освіта', '0101');
INSERT INTO gzdic VALUES (2, '0102 Фізичне виховання, спорт і здоров’я людини', '0102');
INSERT INTO gzdic VALUES (3, '0202 Мистецтво', '0202');
INSERT INTO gzdic VALUES (4, '0203 Гуманітарні науки', '0203');
INSERT INTO gzdic VALUES (5, '0301 Соціально-політичні науки', '0301');
INSERT INTO gzdic VALUES (6, '0302 Міжнародні відносини', '0302');
INSERT INTO gzdic VALUES (7, '0303 Журналістика та інформація', '0303');
INSERT INTO gzdic VALUES (8, '0304 Право', '0304');
INSERT INTO gzdic VALUES (9, '0305 Економіка та підприємництво', '0305');
INSERT INTO gzdic VALUES (10, '0306 Менеджмент і адміністрування', '0306');
INSERT INTO gzdic VALUES (11, '0401 Природничі науки', '0401');
INSERT INTO gzdic VALUES (12, '0402 Фізико-математичні науки', '0402');
INSERT INTO gzdic VALUES (13, '0403 Системні науки та кібернетика', '0403');
INSERT INTO gzdic VALUES (14, '0501 Інформатика та обчислювальна техніка', '0501');
INSERT INTO gzdic VALUES (15, '0901 Сільське господарство і лісництво', '0901');
INSERT INTO gzdic VALUES (16, '1301 Соціальне забезпечення', '1301');
INSERT INTO gzdic VALUES (17, '1401 Сфера обслуговування', '1401');
INSERT INTO gzdic VALUES (18, '1501 Державне управління', '1501');


--
-- Name: gzdic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('gzdic_id', 1, false);


--
-- Data for Name: legendic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO legendic VALUES (1, 'Т', 'Теоретичне навчання');
INSERT INTO legendic VALUES (2, 'С', 'Екзаменаційна сесія');
INSERT INTO legendic VALUES (4, 'К', 'Канікули');
INSERT INTO legendic VALUES (5, 'ДЕ', 'Складання державного екзамену');
INSERT INTO legendic VALUES (8, 'ДП', 'Захист дипломного проекту (роботи)');
INSERT INTO legendic VALUES (9, 'ВП', 'Виробнича праткика');
INSERT INTO legendic VALUES (10, 'НП', 'Навчальна практика');
INSERT INTO legendic VALUES (11, 'НС', 'Настановча сесія');
INSERT INTO legendic VALUES (12, 'Д', 'Дипломування');


--
-- Name: legendic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('legendic_id', 3, true);


--
-- Data for Name: npdic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO npdic VALUES (1, '6.010106 Соціальна педагогіка', '6.010106', 1, 13);
INSERT INTO npdic VALUES (2, '6.010201 Фізичне виховання', '6.010201', 2, 7);
INSERT INTO npdic VALUES (3, '6.010202 Спорт', '6.010202', 2, 7);
INSERT INTO npdic VALUES (4, '6.010203 Здоров’я людини', '6.010203', 2, 7);
INSERT INTO npdic VALUES (5, '6.020201 Театральне мистецтво', '6.020201', 3, 13);
INSERT INTO npdic VALUES (6, '6.020207 Дизайн', '6.020207', 3, 13);
INSERT INTO npdic VALUES (7, '6.020302 Історія', '6.020302', 4, 4);
INSERT INTO npdic VALUES (8, '6.020303 Філологія', '6.020303', 4, 10);
INSERT INTO npdic VALUES (9, '6.030101 Соціологія', '6.030101', 5, 8);
INSERT INTO npdic VALUES (10, '6.030102 Психологія', '6.030102', 5, 13);
INSERT INTO npdic VALUES (11, '6.030104 Політологія', '6.030104', 5, 8);
INSERT INTO npdic VALUES (12, '6.030205 Країнознавство', '6.030205', 6, 4);
INSERT INTO npdic VALUES (13, '6.030301 Журналістика', '6.030301', 7, 11);
INSERT INTO npdic VALUES (14, '6.030302 Реклама і зв’язки з громадськістю', '6.030302', 7, 11);
INSERT INTO npdic VALUES (15, '6.030303 Видавнича справа та редагування', '6.030303', 7, 11);
INSERT INTO npdic VALUES (16, '6.030401 Правознавство', '6.030401', 8, 5);
INSERT INTO npdic VALUES (17, '6.030502 Економічна кібернетика', '6.030502', 9, 3);
INSERT INTO npdic VALUES (18, '6.030503 Міжнародна економіка', '6.030503', 9, 3);
INSERT INTO npdic VALUES (19, '6.030505 Управління персоналом та економіка праці', '6.030505', 9, 3);
INSERT INTO npdic VALUES (20, '6.030508 Фінанси і кредит', '6.030508', 9, 3);
INSERT INTO npdic VALUES (21, '6.030509 Облік і аудит', '6.030508', 9, 3);
INSERT INTO npdic VALUES (22, '6.030601 Менеджмент', '6.030601', 10, 9);
INSERT INTO npdic VALUES (23, '6.040101 Хімія', '6.040101', 11, 6);
INSERT INTO npdic VALUES (24, '6.040102 Біологія', '6.040106', 11, 6);
INSERT INTO npdic VALUES (25, '6.040106 Екологія, охорона навколишнього середовища та збалансоване природокористування', '6.040106', 11, 6);
INSERT INTO npdic VALUES (26, '6.040201 Математика', '6.040201', 12, 1);
INSERT INTO npdic VALUES (27, '6.040203 Фізика', '6.040203', 12, 2);
INSERT INTO npdic VALUES (28, '6.040204 Прикладна фізика', '6.040204', 12, 2);
INSERT INTO npdic VALUES (29, '6.040301 Прикладна математика', '6.040204', 13, 1);
INSERT INTO npdic VALUES (30, '6.040302 Інформатика', '6.040302', 13, 1);
INSERT INTO npdic VALUES (31, '6.050103 Програмна інженерія', '6.050103', 14, 1);
INSERT INTO npdic VALUES (33, '6.130102 Соціальна робота', '6.130102', 16, 8);
INSERT INTO npdic VALUES (34, '6.140103 Туризм', '6.140103', 17, 7);
INSERT INTO npdic VALUES (35, '6.020303 Філологія. Мова і література (англійська, іспанська, німецька, французька)', '6.020303', 4, 12);
INSERT INTO npdic VALUES (36, '6.020303 Філологія. Переклад (англійська, німецька, французька мова)', '6.020303', 4, 12);


--
-- Name: npdic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('npdic_id', 1, false);


--
-- Data for Name: okrdic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO okrdic VALUES (1, 'Молодший спеціаліст', '5');
INSERT INTO okrdic VALUES (2, 'Бакалавр', '6');
INSERT INTO okrdic VALUES (3, 'Спеціаліст', '7');
INSERT INTO okrdic VALUES (4, 'Магістр', '8');


--
-- Name: okrdic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('okrdic_id', 4, true);


--
-- Data for Name: plan; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO plan VALUES (27, NULL, '2013_Спеціаліст_Дистанційна__7.13010201 Соціальна робота_');
INSERT INTO plan VALUES (28, NULL, '2014_Бакалавр_Денна_6.020201 Театральне мистецтво__');
INSERT INTO plan VALUES (29, NULL, '2014_Бакалавр_Денна_6.050103 Програмна інженерія__');


--
-- Name: plan_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('plan_id', 29, true);


--
-- Data for Name: planvalues; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO planvalues VALUES (573, 1, 4, '', 28);
INSERT INTO planvalues VALUES (574, 1, 5, '', 28);
INSERT INTO planvalues VALUES (575, 1, 6, '', 28);
INSERT INTO planvalues VALUES (576, 1, 7, 'ВП', 28);
INSERT INTO planvalues VALUES (577, 1, 8, '', 28);
INSERT INTO planvalues VALUES (578, 1, 9, '', 28);
INSERT INTO planvalues VALUES (579, 1, 10, '', 28);
INSERT INTO planvalues VALUES (580, 1, 11, '', 28);
INSERT INTO planvalues VALUES (581, 1, 12, '', 28);
INSERT INTO planvalues VALUES (582, 1, 13, '', 28);
INSERT INTO planvalues VALUES (583, 1, 14, '', 28);
INSERT INTO planvalues VALUES (584, 1, 15, 'ВП', 28);
INSERT INTO planvalues VALUES (586, 1, 17, '', 28);
INSERT INTO planvalues VALUES (587, 1, 18, '', 28);
INSERT INTO planvalues VALUES (588, 1, 19, '', 28);
INSERT INTO planvalues VALUES (589, 1, 20, '', 28);
INSERT INTO planvalues VALUES (590, 1, 21, '', 28);
INSERT INTO planvalues VALUES (591, 1, 22, '', 28);
INSERT INTO planvalues VALUES (592, 1, 23, '', 28);
INSERT INTO planvalues VALUES (593, 1, 24, '', 28);
INSERT INTO planvalues VALUES (594, 1, 25, '', 28);
INSERT INTO planvalues VALUES (595, 1, 26, '', 28);
INSERT INTO planvalues VALUES (596, 1, 27, '', 28);
INSERT INTO planvalues VALUES (597, 1, 28, '', 28);
INSERT INTO planvalues VALUES (599, 1, 30, '', 28);
INSERT INTO planvalues VALUES (600, 1, 31, '', 28);
INSERT INTO planvalues VALUES (601, 1, 32, '', 28);
INSERT INTO planvalues VALUES (602, 1, 33, '', 28);
INSERT INTO planvalues VALUES (603, 1, 34, '', 28);
INSERT INTO planvalues VALUES (604, 1, 35, '', 28);
INSERT INTO planvalues VALUES (605, 1, 36, '', 28);
INSERT INTO planvalues VALUES (606, 1, 37, '', 28);
INSERT INTO planvalues VALUES (607, 1, 38, '', 28);
INSERT INTO planvalues VALUES (608, 1, 39, '', 28);
INSERT INTO planvalues VALUES (609, 1, 40, '', 28);
INSERT INTO planvalues VALUES (610, 1, 41, '', 28);
INSERT INTO planvalues VALUES (612, 1, 43, '', 28);
INSERT INTO planvalues VALUES (613, 1, 44, '', 28);
INSERT INTO planvalues VALUES (614, 1, 45, '', 28);
INSERT INTO planvalues VALUES (615, 1, 46, '', 28);
INSERT INTO planvalues VALUES (616, 1, 47, '', 28);
INSERT INTO planvalues VALUES (617, 1, 48, '', 28);
INSERT INTO planvalues VALUES (618, 1, 49, '', 28);
INSERT INTO planvalues VALUES (619, 1, 50, '', 28);
INSERT INTO planvalues VALUES (620, 1, 51, '', 28);
INSERT INTO planvalues VALUES (464, 1, 1, 'ДЕ', 27);
INSERT INTO planvalues VALUES (465, 1, 2, '', 27);
INSERT INTO planvalues VALUES (466, 1, 3, '', 27);
INSERT INTO planvalues VALUES (468, 1, 5, '', 27);
INSERT INTO planvalues VALUES (469, 1, 6, '', 27);
INSERT INTO planvalues VALUES (470, 1, 7, '', 27);
INSERT INTO planvalues VALUES (471, 1, 8, '', 27);
INSERT INTO planvalues VALUES (472, 1, 9, '', 27);
INSERT INTO planvalues VALUES (473, 1, 10, '', 27);
INSERT INTO planvalues VALUES (474, 1, 11, '', 27);
INSERT INTO planvalues VALUES (475, 1, 12, '', 27);
INSERT INTO planvalues VALUES (476, 1, 13, '', 27);
INSERT INTO planvalues VALUES (477, 1, 14, '', 27);
INSERT INTO planvalues VALUES (478, 1, 15, '', 27);
INSERT INTO planvalues VALUES (479, 1, 16, '', 27);
INSERT INTO planvalues VALUES (481, 1, 18, '', 27);
INSERT INTO planvalues VALUES (482, 1, 19, '', 27);
INSERT INTO planvalues VALUES (483, 1, 20, '', 27);
INSERT INTO planvalues VALUES (484, 1, 21, '', 27);
INSERT INTO planvalues VALUES (485, 1, 22, '', 27);
INSERT INTO planvalues VALUES (486, 1, 23, '', 27);
INSERT INTO planvalues VALUES (487, 1, 24, '', 27);
INSERT INTO planvalues VALUES (488, 1, 25, '', 27);
INSERT INTO planvalues VALUES (489, 1, 26, '', 27);
INSERT INTO planvalues VALUES (490, 1, 27, '', 27);
INSERT INTO planvalues VALUES (491, 1, 28, '', 27);
INSERT INTO planvalues VALUES (492, 1, 29, '', 27);
INSERT INTO planvalues VALUES (494, 1, 31, '', 27);
INSERT INTO planvalues VALUES (495, 1, 32, '', 27);
INSERT INTO planvalues VALUES (496, 1, 33, '', 27);
INSERT INTO planvalues VALUES (497, 1, 34, '', 27);
INSERT INTO planvalues VALUES (498, 1, 35, '', 27);
INSERT INTO planvalues VALUES (499, 1, 36, '', 27);
INSERT INTO planvalues VALUES (500, 1, 37, '', 27);
INSERT INTO planvalues VALUES (501, 1, 38, '', 27);
INSERT INTO planvalues VALUES (502, 1, 39, '', 27);
INSERT INTO planvalues VALUES (503, 1, 40, '', 27);
INSERT INTO planvalues VALUES (504, 1, 41, '', 27);
INSERT INTO planvalues VALUES (505, 1, 42, '', 27);
INSERT INTO planvalues VALUES (507, 1, 44, '', 27);
INSERT INTO planvalues VALUES (508, 1, 45, '', 27);
INSERT INTO planvalues VALUES (509, 1, 46, '', 27);
INSERT INTO planvalues VALUES (510, 1, 47, '', 27);
INSERT INTO planvalues VALUES (511, 1, 48, '', 27);
INSERT INTO planvalues VALUES (512, 1, 49, '', 27);
INSERT INTO planvalues VALUES (513, 1, 50, '', 27);
INSERT INTO planvalues VALUES (514, 1, 51, '', 27);
INSERT INTO planvalues VALUES (515, 1, 52, '', 27);
INSERT INTO planvalues VALUES (516, 1, 53, '', 27);
INSERT INTO planvalues VALUES (517, 2, 1, 'ДП', 27);
INSERT INTO planvalues VALUES (518, 2, 2, '', 27);
INSERT INTO planvalues VALUES (520, 2, 4, '', 27);
INSERT INTO planvalues VALUES (521, 2, 5, '', 27);
INSERT INTO planvalues VALUES (522, 2, 6, '', 27);
INSERT INTO planvalues VALUES (523, 2, 7, '', 27);
INSERT INTO planvalues VALUES (524, 2, 8, '', 27);
INSERT INTO planvalues VALUES (525, 2, 9, '', 27);
INSERT INTO planvalues VALUES (526, 2, 10, '', 27);
INSERT INTO planvalues VALUES (527, 2, 11, 'НП', 27);
INSERT INTO planvalues VALUES (528, 2, 12, '', 27);
INSERT INTO planvalues VALUES (529, 2, 13, '', 27);
INSERT INTO planvalues VALUES (530, 2, 14, '', 27);
INSERT INTO planvalues VALUES (531, 2, 15, '', 27);
INSERT INTO planvalues VALUES (533, 2, 17, '', 27);
INSERT INTO planvalues VALUES (534, 2, 18, '', 27);
INSERT INTO planvalues VALUES (535, 2, 19, '', 27);
INSERT INTO planvalues VALUES (536, 2, 20, '', 27);
INSERT INTO planvalues VALUES (537, 2, 21, '', 27);
INSERT INTO planvalues VALUES (538, 2, 22, '', 27);
INSERT INTO planvalues VALUES (539, 2, 23, '', 27);
INSERT INTO planvalues VALUES (540, 2, 24, '', 27);
INSERT INTO planvalues VALUES (541, 2, 25, '', 27);
INSERT INTO planvalues VALUES (542, 2, 26, '', 27);
INSERT INTO planvalues VALUES (543, 2, 27, '', 27);
INSERT INTO planvalues VALUES (544, 2, 28, '', 27);
INSERT INTO planvalues VALUES (546, 2, 30, '', 27);
INSERT INTO planvalues VALUES (547, 2, 31, '', 27);
INSERT INTO planvalues VALUES (548, 2, 32, '', 27);
INSERT INTO planvalues VALUES (549, 2, 33, '', 27);
INSERT INTO planvalues VALUES (550, 2, 34, '', 27);
INSERT INTO planvalues VALUES (551, 2, 35, '', 27);
INSERT INTO planvalues VALUES (552, 2, 36, '', 27);
INSERT INTO planvalues VALUES (553, 2, 37, '', 27);
INSERT INTO planvalues VALUES (554, 2, 38, '', 27);
INSERT INTO planvalues VALUES (555, 2, 39, '', 27);
INSERT INTO planvalues VALUES (556, 2, 40, '', 27);
INSERT INTO planvalues VALUES (557, 2, 41, '', 27);
INSERT INTO planvalues VALUES (559, 2, 43, '', 27);
INSERT INTO planvalues VALUES (467, 1, 4, '', 27);
INSERT INTO planvalues VALUES (480, 1, 17, '', 27);
INSERT INTO planvalues VALUES (493, 1, 30, '', 27);
INSERT INTO planvalues VALUES (506, 1, 43, '', 27);
INSERT INTO planvalues VALUES (519, 2, 3, '', 27);
INSERT INTO planvalues VALUES (532, 2, 16, '', 27);
INSERT INTO planvalues VALUES (545, 2, 29, '', 27);
INSERT INTO planvalues VALUES (558, 2, 42, '', 27);
INSERT INTO planvalues VALUES (560, 2, 44, '', 27);
INSERT INTO planvalues VALUES (561, 2, 45, '', 27);
INSERT INTO planvalues VALUES (562, 2, 46, '', 27);
INSERT INTO planvalues VALUES (563, 2, 47, '', 27);
INSERT INTO planvalues VALUES (564, 2, 48, '', 27);
INSERT INTO planvalues VALUES (565, 2, 49, '', 27);
INSERT INTO planvalues VALUES (566, 2, 50, '', 27);
INSERT INTO planvalues VALUES (567, 2, 51, '', 27);
INSERT INTO planvalues VALUES (568, 2, 52, '', 27);
INSERT INTO planvalues VALUES (569, 2, 53, '', 27);
INSERT INTO planvalues VALUES (623, 1, 1, '', 29);
INSERT INTO planvalues VALUES (624, 1, 2, 'ВП', 29);
INSERT INTO planvalues VALUES (625, 1, 3, '', 29);
INSERT INTO planvalues VALUES (626, 1, 4, '', 29);
INSERT INTO planvalues VALUES (627, 1, 5, '', 29);
INSERT INTO planvalues VALUES (628, 1, 6, 'ДП', 29);
INSERT INTO planvalues VALUES (629, 1, 7, '', 29);
INSERT INTO planvalues VALUES (630, 1, 8, '', 29);
INSERT INTO planvalues VALUES (631, 1, 9, '', 29);
INSERT INTO planvalues VALUES (632, 1, 10, '', 29);
INSERT INTO planvalues VALUES (633, 1, 11, '', 29);
INSERT INTO planvalues VALUES (634, 1, 12, '', 29);
INSERT INTO planvalues VALUES (635, 1, 13, '', 29);
INSERT INTO planvalues VALUES (636, 1, 14, '', 29);
INSERT INTO planvalues VALUES (637, 1, 15, '', 29);
INSERT INTO planvalues VALUES (638, 1, 16, '', 29);
INSERT INTO planvalues VALUES (639, 1, 17, '', 29);
INSERT INTO planvalues VALUES (640, 1, 18, '', 29);
INSERT INTO planvalues VALUES (641, 1, 19, '', 29);
INSERT INTO planvalues VALUES (642, 1, 20, '', 29);
INSERT INTO planvalues VALUES (643, 1, 21, '', 29);
INSERT INTO planvalues VALUES (644, 1, 22, '', 29);
INSERT INTO planvalues VALUES (645, 1, 23, '', 29);
INSERT INTO planvalues VALUES (646, 1, 24, '', 29);
INSERT INTO planvalues VALUES (647, 1, 25, '', 29);
INSERT INTO planvalues VALUES (648, 1, 26, '', 29);
INSERT INTO planvalues VALUES (649, 1, 27, '', 29);
INSERT INTO planvalues VALUES (650, 1, 28, '', 29);
INSERT INTO planvalues VALUES (651, 1, 29, '', 29);
INSERT INTO planvalues VALUES (652, 1, 30, '', 29);
INSERT INTO planvalues VALUES (653, 1, 31, '', 29);
INSERT INTO planvalues VALUES (654, 1, 32, '', 29);
INSERT INTO planvalues VALUES (655, 1, 33, '', 29);
INSERT INTO planvalues VALUES (656, 1, 34, '', 29);
INSERT INTO planvalues VALUES (657, 1, 35, '', 29);
INSERT INTO planvalues VALUES (658, 1, 36, '', 29);
INSERT INTO planvalues VALUES (659, 1, 37, '', 29);
INSERT INTO planvalues VALUES (660, 1, 38, '', 29);
INSERT INTO planvalues VALUES (661, 1, 39, '', 29);
INSERT INTO planvalues VALUES (662, 1, 40, '', 29);
INSERT INTO planvalues VALUES (663, 1, 41, '', 29);
INSERT INTO planvalues VALUES (664, 1, 42, '', 29);
INSERT INTO planvalues VALUES (665, 1, 43, '', 29);
INSERT INTO planvalues VALUES (666, 1, 44, '', 29);
INSERT INTO planvalues VALUES (667, 1, 45, '', 29);
INSERT INTO planvalues VALUES (668, 1, 46, '', 29);
INSERT INTO planvalues VALUES (669, 1, 47, '', 29);
INSERT INTO planvalues VALUES (670, 1, 48, '', 29);
INSERT INTO planvalues VALUES (671, 1, 49, '', 29);
INSERT INTO planvalues VALUES (672, 1, 50, '', 29);
INSERT INTO planvalues VALUES (673, 1, 51, '', 29);
INSERT INTO planvalues VALUES (674, 1, 52, '', 29);
INSERT INTO planvalues VALUES (675, 1, 53, '', 29);
INSERT INTO planvalues VALUES (570, 1, 1, 'НС', 28);
INSERT INTO planvalues VALUES (571, 1, 2, '', 28);
INSERT INTO planvalues VALUES (572, 1, 3, 'ДЕ', 28);
INSERT INTO planvalues VALUES (585, 1, 16, '', 28);
INSERT INTO planvalues VALUES (598, 1, 29, '', 28);
INSERT INTO planvalues VALUES (611, 1, 42, '', 28);
INSERT INTO planvalues VALUES (621, 1, 52, '', 28);
INSERT INTO planvalues VALUES (622, 1, 53, '', 28);


--
-- Data for Name: spdic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO spdic VALUES (1, '7.01010601 Соціальна педагогіка', '7.01010601', 1, 3, 13);
INSERT INTO spdic VALUES (2, '7.01020101 Фізичне виховання', '7.01020101', 2, 3, 7);
INSERT INTO spdic VALUES (3, '7.01020201 Спорт (за видами)', '7.01020302', 2, 3, 7);
INSERT INTO spdic VALUES (4, '7.01020302 Фізична реабілітація', '7.01020302', 2, 3, 7);
INSERT INTO spdic VALUES (5, '7.02020101 Театральне мистецтво (за видами)', '7.02020101', 3, 3, 13);
INSERT INTO spdic VALUES (6, '7.02030201 Історія', '7.02030201', 4, 3, 4);
INSERT INTO spdic VALUES (7, '7.02030203 Архівознавство', '7.02030203', 4, 3, 4);
INSERT INTO spdic VALUES (8, '7.02030301 Українська мова і література', '7.02030301', 4, 3, 10);
INSERT INTO spdic VALUES (9, '7.02030302 Мова і література (російська)', '7.02030302', 4, 3, 10);
INSERT INTO spdic VALUES (10, '7.02030302 Мова і література (англійська, німецька, французька, іспанська)', '7.02030303', 4, 3, 12);
INSERT INTO spdic VALUES (11, '7.02030304 Переклад', '7.02030304', 4, 3, 12);
INSERT INTO spdic VALUES (12, '7.03010101 Соціологія (за видами діяльності)', '7.03010101', 5, 3, 8);
INSERT INTO spdic VALUES (13, '7.03010201 Психологія', '7.03010201', 5, 3, 13);
INSERT INTO spdic VALUES (14, '7.03010401 Політологія (за сферами політичної діяльності)', '7.03010401', 5, 3, 8);
INSERT INTO spdic VALUES (15, '7.03020501 Країнознавство', '7.03020501', 6, 3, 4);
INSERT INTO spdic VALUES (16, '7.03030101 Журналістика (за видами)', '7.03030101', 7, 3, 11);
INSERT INTO spdic VALUES (17, '7.03030201 Реклама', '7.03030201', 7, 3, 11);
INSERT INTO spdic VALUES (18, '7.03030202 Зв’язки з громадськістю', '7.03030202', 7, 3, 11);
INSERT INTO spdic VALUES (19, '7.03030301 Видавнича справа та редагування', '7.03030301', 7, 3, 11);
INSERT INTO spdic VALUES (20, '7.03040101 Правознавство', '7.03040101', 8, 3, 5);
INSERT INTO spdic VALUES (21, '7.03050201 Економічна кібернетика', '7.03050201', 9, 3, 3);
INSERT INTO spdic VALUES (22, '7.03050301 Міжнародна економіка', '7.03050301', 9, 3, 3);
INSERT INTO spdic VALUES (23, '7.03050801 Фінанси і кредит (за спеціалізованими програмами)', '7.03050801', 9, 3, 3);
INSERT INTO spdic VALUES (24, '7.03050802 Банківська справа', '7.03050802', 9, 3, 3);
INSERT INTO spdic VALUES (25, '7.03050901 Облік і аудит', '7.03050901', 9, 3, 3);
INSERT INTO spdic VALUES (33, '7.03060101 Менеджмент організацій і адміністрування (за видами економічної діяльності)', '7.03060101', 10, 3, 9);
INSERT INTO spdic VALUES (34, '7.03060104 Менеджмент зовнішньоекономічної діяльності', '7.03060104', 10, 3, 9);
INSERT INTO spdic VALUES (35, '7.03060107 Логістика', '7.03060107', 10, 3, 9);
INSERT INTO spdic VALUES (36, '7.04010101 Хімія', '7.04010101', 11, 3, 6);
INSERT INTO spdic VALUES (37, '7.04010201 Біологія', '7.04010201', 11, 3, 6);
INSERT INTO spdic VALUES (38, '7.04010601 Екологія та охорона навколишнього середовища', '7.04010601', 11, 3, 6);
INSERT INTO spdic VALUES (39, '7.04020101 Математика (за напрямами)', '7.04020101', 12, 3, 1);
INSERT INTO spdic VALUES (40, '7.04020301 Фізика (за напрямами)', '7.04020301', 12, 3, 2);
INSERT INTO spdic VALUES (41, '7.04020302 Фізика конденсованого стану', '7.04020302', 12, 3, 2);
INSERT INTO spdic VALUES (42, '7.04020401 Прикладна фізика (за галузями використання)', '7.04020401', 12, 3, 2);
INSERT INTO spdic VALUES (43, '7.04030101 Прикладна математика', '7.04030101', 13, 3, 1);
INSERT INTO spdic VALUES (44, '7.04030201 Інформатика', '7.04030201', 13, 3, 1);
INSERT INTO spdic VALUES (45, '7.13010201 Соціальна робота', '7.13010201', 16, 3, 13);
INSERT INTO spdic VALUES (46, '7.14010301 Туризмознавство (за видами)', '7.14010301', 17, 3, 7);
INSERT INTO spdic VALUES (47, '8.01010601 Соціальна педагогіка', '8.01010601', 1, 4, 13);
INSERT INTO spdic VALUES (48, '8.01020101 Фізичне виховання', '8.01020101', 2, 4, 7);
INSERT INTO spdic VALUES (49, '8.01020201 Спорт (за видами)', '8.01020201', 2, 4, 7);
INSERT INTO spdic VALUES (50, '8.01020302 Фізична реабілітація', '8.01020302', 2, 4, 7);
INSERT INTO spdic VALUES (51, '8.02030201 Історія', '8.02030201', 4, 4, 4);
INSERT INTO spdic VALUES (52, '8.02030203 Архівознавство', '8.02030203', 4, 4, 4);
INSERT INTO spdic VALUES (53, '8.02030301 Українська мова і література', '8.02030301', 4, 4, 10);
INSERT INTO spdic VALUES (54, '8.02030302 Мова і література (російська)', '8.02030302', 4, 4, 10);
INSERT INTO spdic VALUES (55, '8.02030302 Мова і література (англійська, німецька, французька, іспанська)', '8.02030302', 4, 4, 12);
INSERT INTO spdic VALUES (56, '8.02030304 Переклад', '8.02030304', 4, 4, 12);
INSERT INTO spdic VALUES (57, '8.03010101 Соціологія (за видами діяльності)', '8.03010101', 5, 4, 8);
INSERT INTO spdic VALUES (58, '8.03010201 Психологія', '8.03010201', 5, 4, 13);
INSERT INTO spdic VALUES (59, '8.03010401 Політологія (за сферами політичної діяльності)', '8.03010401', 5, 4, 8);
INSERT INTO spdic VALUES (60, '8.03030101 Журналістика (за видами)', '8.03030101', 7, 4, 11);
INSERT INTO spdic VALUES (61, '8.03030201 Реклама', '8.03030201', 7, 4, 11);
INSERT INTO spdic VALUES (62, '8.03030202 Зв’язки з громадськістю', '8.03030202', 7, 4, 11);
INSERT INTO spdic VALUES (63, '8.03040101 Правознавство', '8.03040101', 8, 4, 3);
INSERT INTO spdic VALUES (64, '8.03050201 Економічна кібернетика', '8.03050201', 9, 4, 3);
INSERT INTO spdic VALUES (65, '8.03050301 Міжнародна економіка', '8.03050301', 9, 4, 3);
INSERT INTO spdic VALUES (66, '8.03050801 Фінанси і кредит (за спеціалізованими програмами)', '8.03050801', 9, 4, 3);
INSERT INTO spdic VALUES (67, '8.03050901 Облік і аудит', '8.03050901', 9, 4, 3);
INSERT INTO spdic VALUES (68, '8.03060101 Менеджмент організацій і адміністрування (за видами економічної діяльності)', '8.03060101', 10, 4, 9);
INSERT INTO spdic VALUES (69, '8.03060104 Менеджмент зовнішньоекономічної діяльності', '8.03060104', 10, 4, 9);
INSERT INTO spdic VALUES (70, '8.03060107 Логістика', '8.03060107', 10, 4, 9);
INSERT INTO spdic VALUES (71, '8.04010101 Хімія', '8.04010101', 11, 4, 6);
INSERT INTO spdic VALUES (72, '8.04010201 Біологія', '8.04010201', 11, 4, 6);
INSERT INTO spdic VALUES (73, '8.04010209 Генетика', '8.04010209', 11, 4, 6);
INSERT INTO spdic VALUES (74, '8.04010601 Екологія та охорона навколишнього середовища', '8.04010601', 11, 4, 6);
INSERT INTO spdic VALUES (75, '8.04020101 Математика (за напрямами)', '8.04020101', 12, 4, 1);
INSERT INTO spdic VALUES (76, '8.04020301 Фізика (за напрямами)', '8.04020301', 12, 4, 2);
INSERT INTO spdic VALUES (77, '8.04020302 Фізика конденсованого стану', '8.04020302', 12, 4, 2);
INSERT INTO spdic VALUES (78, '8.04030101 Прикладна математика', '8.04030101', 13, 4, 1);
INSERT INTO spdic VALUES (79, '8.04030201 Інформатика', '8.04030201', 13, 4, 1);
INSERT INTO spdic VALUES (81, '7.02030302 Мова і література (англійська, іспанська, німецька, французька)', '7.02030302', 4, 3, 12);
INSERT INTO spdic VALUES (82, '7.02030304 Переклад (англійська, німецька, французька мова)', '7.02030304', 4, 3, 12);
INSERT INTO spdic VALUES (83, '8.02030302 Мова і література (англійська, іспанська, німецька, французька)', '8.02030302', 4, 4, 12);
INSERT INTO spdic VALUES (84, '8.02030304 Переклад (англійська, німецька, французька мова)', '8.02030304', 4, 4, 12);
INSERT INTO spdic VALUES (85, '8.15010002 Державна служба', '8.15010002', 18, 4, 8);
INSERT INTO spdic VALUES (86, '8.04020401 Прикладна фізика (за галузями використання)', '8.04020401', 12, 4, 2);


--
-- Name: spdic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('spdic_id', 1, false);


--
-- Data for Name: subspdic; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO subspdic VALUES (1, 'Історія України', 6);
INSERT INTO subspdic VALUES (2, 'Всесвітня історія', 6);
INSERT INTO subspdic VALUES (3, 'Джерелознавство, історіографія та спеціальні історичні дисципліни', 6);
INSERT INTO subspdic VALUES (4, 'Країнознавство (за регіонами)', 15);
INSERT INTO subspdic VALUES (5, 'Документознавство та документаційне забезпечення управління', 7);
INSERT INTO subspdic VALUES (6, 'Історія України', 51);
INSERT INTO subspdic VALUES (7, 'Всесвітня історія', 6);
INSERT INTO subspdic VALUES (8, 'Джерелознавство, історіографія та спеціальні історичні дисципліни', 6);
INSERT INTO subspdic VALUES (9, 'Документознавство та документаційне забезпечення управління', 7);
INSERT INTO subspdic VALUES (10, 'Фізичне виховання дітей дошкільного віку', 2);
INSERT INTO subspdic VALUES (11, 'Український рукопаш "Спас"', 2);
INSERT INTO subspdic VALUES (12, 'Фізична рекреація', 4);
INSERT INTO subspdic VALUES (13, 'Спортивна реабілітація', 4);
INSERT INTO subspdic VALUES (14, 'Фізика напівпровідників', 77);
INSERT INTO subspdic VALUES (15, 'Компьютерні технології та моделювання в фізиці', 77);


--
-- Name: subspdic_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('subspdic_id', 1, false);


--
-- Name: values_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('values_id', 675, true);


--
-- Name: PlanValues_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY planvalues
    ADD CONSTRAINT "PlanValues_pkey" PRIMARY KEY (id);


--
-- Name: dnamedic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dnamedic
    ADD CONSTRAINT dnamedic_pkey PRIMARY KEY (code);


--
-- Name: dsubtypedic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dsubtypedic
    ADD CONSTRAINT dsubtypedic_pkey PRIMARY KEY (code);


--
-- Name: gzdic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY gzdic
    ADD CONSTRAINT gzdic_pkey PRIMARY KEY (code);


--
-- Name: npdic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY npdic
    ADD CONSTRAINT npdic_pkey PRIMARY KEY (code);


--
-- Name: okrdic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY okrdic
    ADD CONSTRAINT okrdic_pkey PRIMARY KEY (code);


--
-- Name: plan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan
    ADD CONSTRAINT plan_pkey PRIMARY KEY (idplan);


--
-- Name: spdic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY spdic
    ADD CONSTRAINT spdic_pkey PRIMARY KEY (code);


--
-- Name: subspdic_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY subspdic
    ADD CONSTRAINT subspdic_pkey PRIMARY KEY (code);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

