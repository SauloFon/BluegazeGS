using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using bluegaze.Data;
using bluegaze.Models;

namespace bluegaze.Controllers
{
    public class UsuariosModelsController : Controller
    {
        private readonly DbaseContext _context;

        public UsuariosModelsController(DbaseContext context)
        {
            _context = context;
        }

        
        public async Task<IActionResult> Index()
        {
            return View(await _context.UsuariosModel.ToListAsync());
        }

        
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var usuariosModel = await _context.UsuariosModel
                .FirstOrDefaultAsync(m => m.Id == id);
            if (usuariosModel == null)
            {
                return NotFound();
            }

            return View(usuariosModel);
        }

        
        public IActionResult Create()
        {
            return View();
        }

        
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Username,Email,CriadoEm")] UsuariosModel usuariosModel)
        {
            if (ModelState.IsValid)
            {
                _context.Add(usuariosModel);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(usuariosModel);
        }

        
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var usuariosModel = await _context.UsuariosModel.FindAsync(id);
            if (usuariosModel == null)
            {
                return NotFound();
            }
            return View(usuariosModel);
        }

      
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Username,Email,CriadoEm")] UsuariosModel usuariosModel)
        {
            if (id != usuariosModel.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(usuariosModel);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!UsuariosModelExists(usuariosModel.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(usuariosModel);
        }

      
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var usuariosModel = await _context.UsuariosModel
                .FirstOrDefaultAsync(m => m.Id == id);
            if (usuariosModel == null)
            {
                return NotFound();
            }

            return View(usuariosModel);
        }

        
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var usuariosModel = await _context.UsuariosModel.FindAsync(id);
            if (usuariosModel != null)
            {
                _context.UsuariosModel.Remove(usuariosModel);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool UsuariosModelExists(int id)
        {
            return _context.UsuariosModel.Any(e => e.Id == id);
        }
    }
}
