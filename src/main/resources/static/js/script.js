// ==========================================================================
// Abhay Singh — Portfolio interactions
// ==========================================================================

document.addEventListener("DOMContentLoaded", () => {
  initThemeToggle();
  initActiveNavOnScroll();
  initNavClick();
  initContactForm();
});

/* ---------------- Theme toggle (dark / light) ---------------- */
function initThemeToggle() {
  const body = document.body;
  const buttons = document.querySelectorAll(".theme-toggle button");
  if (!buttons.length) return;

  const stored = safeGet("theme");
  if (stored) applyTheme(stored);

  buttons.forEach((btn) => {
    btn.addEventListener("click", () => {
      const choice = btn.getAttribute("data-theme-choice");
      applyTheme(choice);
      safeSet("theme", choice);
    });
  });

  function applyTheme(choice) {
    body.setAttribute("data-theme", choice);
    buttons.forEach((b) =>
        b.classList.toggle("active", b.getAttribute("data-theme-choice") === choice)
    );
  }
}

// in-memory fallback (avoids relying on localStorage in restrictive contexts)
const memoryStore = {};
function safeSet(key, value) {
  try {
    localStorage.setItem(key, value);
  } catch (e) {
    memoryStore[key] = value;
  }
}
function safeGet(key) {
  try {
    return localStorage.getItem(key);
  } catch (e) {
    return memoryStore[key];
  }
}

/* ---------------- Highlight active sidebar link while scrolling ---------------- */
function initActiveNavOnScroll() {
  const sections = document.querySelectorAll("main section[id], main .card[id]");
  const navItems = document.querySelectorAll(".nav-item");
  if (!sections.length || !navItems.length) return;

  const map = new Map();
  navItems.forEach((item) => {
    const href = item.getAttribute("href");
    if (href && href.startsWith("#")) map.set(href.slice(1), item);
  });

  const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          const id = entry.target.getAttribute("id");
          const navItem = map.get(id);
          if (!navItem) return;
          if (entry.isIntersecting) {
            navItems.forEach((n) => n.classList.remove("active"));
            navItem.classList.add("active");
          }
        });
      },
      { rootMargin: "-40% 0px -50% 0px", threshold: 0 }
  );

  sections.forEach((s) => observer.observe(s));
}

/* ---------------- Smooth scroll on nav click (fallback for older browsers) ---------------- */
function initNavClick() {
  document.querySelectorAll('.nav-item[href^="#"]').forEach((link) => {
    link.addEventListener("click", (e) => {
      const targetId = link.getAttribute("href").slice(1);
      const target = document.getElementById(targetId);
      if (target) {
        e.preventDefault();
        target.scrollIntoView({ behavior: "smooth", block: "start" });
      }
    });
  });
}

/* ---------------- Contact form submission ---------------- */
function initContactForm() {
  const form = document.getElementById("contactForm");
  const status = document.getElementById("formStatus");
  if (!form) return;

  form.addEventListener("submit", async (e) => {
    // If a real Spring Boot endpoint (/contact) is wired up, let it POST normally.
    // This handler upgrades the experience to an async submit when possible,
    // and falls back gracefully if the endpoint isn't implemented yet.
    e.preventDefault();
    const submitBtn = form.querySelector(".btn-send");
    const original = submitBtn.innerHTML;
    submitBtn.disabled = true;
    submitBtn.innerHTML = "Sending...";
    status.textContent = "";

    try {
      const formData = new FormData(form);
      const response = await fetch(form.getAttribute("action") || "/contact", {
        method: "POST",
        body: formData,
      });

      if (response.ok) {
        status.textContent = "Message sent successfully. I'll get back to you soon!";
        form.reset();
      } else {
        status.textContent = "Could not send message right now. Please email me directly.";
      }
    } catch (err) {
      status.textContent = "Could not send message right now. Please email me directly.";
    } finally {
      submitBtn.disabled = false;
      submitBtn.innerHTML = original;
    }
  });
}